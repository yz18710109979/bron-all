package com.jy.bron.we.service;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.jy.bron.api.common.Constants;
import com.jy.bron.we.config.WqEnterpriseProperties;
import com.jy.bron.we.domain.dto.enterprise.WeEnterpriseDto;
import com.jy.bron.we.domain.dto.enterprise.WePrementCodeDto;
import com.jy.bron.we.domain.vo.WxCpXmlMessageVO;
import com.jy.bron.we.forest.client.enterprise.WeEnterpriseTokenClient;
import com.jy.bron.we.utils.WxCryptUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import me.chanjar.weixin.common.util.xml.XStreamInitializer;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WqEnterpriseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WqEnterpriseService.class);

    private WqEnterpriseProperties properties;
    private WeEnterpriseTokenClient weEnterpriseTokenClient;
    public WqEnterpriseService(WqEnterpriseProperties properties) {this.properties = properties;}

    public void setWeEnterpriseTokenClient(WeEnterpriseTokenClient weEnterpriseTokenClient) {
        this.weEnterpriseTokenClient = weEnterpriseTokenClient;
    }
    public WeEnterpriseTokenClient getWeEnterpriseTokenClient() {
        return weEnterpriseTokenClient;
    }

    /**
     * 回调
     * get回调验证服务器
     * @param sVerifyMsgSig
     * @param sVerifyTimeStamp
     * @param sVerifyNonce
     * @param sVerifyEchoStr
     * @return
     */
    public String reciveGet(String sVerifyMsgSig, String sVerifyTimeStamp, String sVerifyNonce, String sVerifyEchoStr) {
        String token = properties.getToken();
        String corpId = properties.getCorpId();
        String encodingAesKey = properties.getEncodingAESKey();
        LOGGER.error("Wx GET Call Back, token : {}, corpId : {}, encodingAesKey : {}", token, corpId, encodingAesKey);
        WxCryptUtil wxCryptUtil = new WxCryptUtil(token, encodingAesKey, corpId);
        try {
            return wxCryptUtil.verifyURL(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
        } catch (Exception e) {
            LOGGER.error("Wx GET Call Back Exception : {}", e.getLocalizedMessage());
        }
        return Constants.ERROR;
    }

    public WxCpXmlMessageVO recivePost(String msg, String signature,
                                       String timestamp, String nonce){
        String token = properties.getToken();
        String corpId = properties.getCorpId();
        String encodingAesKey = properties.getEncodingAESKey();
        LOGGER.error("recivePost POST token = {}, corpId = {}, encodingAesKey = {}", token, corpId, encodingAesKey);
        WxCryptUtil wxCryptUtil = new WxCryptUtil(token, encodingAesKey, corpId);
        try {
            String decrypt = wxCryptUtil.decrypt(signature, timestamp, nonce, msg);
            WxCpXmlMessageVO wxCpXmlMessage = StrXmlToBean(decrypt);
            LOGGER.error("recivePost POST Call Back message : {}", JSONUtil.toJsonStr(wxCpXmlMessage));
            return wxCpXmlMessage;
        } catch (Exception e) {
            LOGGER.error("recivePost POST throws Exception : {}", e.getLocalizedMessage());
        }
        return null;
    }

    private WxCpXmlMessageVO StrXmlToBean(String xmlStr){
        XStream xstream = XStreamInitializer.getInstance();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(WxCpXmlMessage.class);
        xstream.processAnnotations(WxCpXmlMessageVO.class);
        xstream.processAnnotations(WxCpXmlMessageVO.ScanCodeInfo.class);
        xstream.processAnnotations(WxCpXmlMessageVO.SendPicsInfo.class);
        xstream.processAnnotations(WxCpXmlMessageVO.SendPicsInfo.Item.class);
        xstream.processAnnotations(WxCpXmlMessageVO.SendLocationInfo.class);
        xstream.processAnnotations(WxCpXmlMessageVO.BatchJob.class);
        WxCpXmlMessageVO wxCpXmlMessage = (WxCpXmlMessageVO)xstream.fromXML(xmlStr);
        return wxCpXmlMessage;
    }


    // 应用安装地址
    public String getInstallUrl(String hostUrl) {
        String installUrl = "";
        WeEnterpriseDto result = this.weEnterpriseTokenClient.getPreAuthCode();
        String code = result.getPre_auth_code();
        // 设置授权
        JSONObject sessionInfo = new JSONObject();
        sessionInfo.put("appid", new int[0]);
        sessionInfo.put("auth_type",properties.getAuthType());
        this.weEnterpriseTokenClient.setSessionInfo(code, sessionInfo);
        String redirectUrl = new StringBuffer(hostUrl).append("/ser/install").toString();
        return String.format(properties.getInstallUrl(), properties.getSuitId() , code, redirectUrl);
    }

    // 应用安装
    public WePrementCodeDto installApp(String authCode) {
        return this.weEnterpriseTokenClient.getPermentCode(authCode);
    }
}
