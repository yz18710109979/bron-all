package com.jy.web;

import cn.hutool.json.JSONUtil;
import com.jy.bron.we.domain.dto.enterprise.WePrementCodeDto;
import com.jy.bron.we.service.WqEnterpriseService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class WeServiceApi {
    @Resource
    WqEnterpriseService enterpriseService;

    // 获取应用安装地址
    @RequestMapping(value = "/ser/index")
    @ResponseBody
    String getInstallUrl(HttpServletRequest request){ return enterpriseService.getInstallUrl(""); }

    // 安装回调
    @GetMapping(value = "/ser/install")
    void install(HttpServletRequest request, @RequestParam(value = "auth_code") String authCode){
        WePrementCodeDto wePrementCodeDto = enterpriseService.installApp(authCode);
//        AuthCorpInfoDto authCorpInfo = wePrementCodeDto.getAuth_corp_info();
//        String corpid = authCorpInfo.getCorpid();
//        List<QwCorpInfo> datas =
//                corpService.selectList(new EntityWrapper<QwCorpInfo>().eq("corp_id", corpid).eq("status", 1));
//        Integer id = null;
//        if (CollectionUtils.isNotEmpty(datas)) {
//            id = datas.get(0).getId();
//        }
//        AuthInfoDto authInfo = wePrementCodeDto.getAuth_info();
//        QwCorpInfo corpInfo = Builder.of(QwCorpInfo::new)
//                .with(QwCorpInfo::setId, id)
//                .with(QwCorpInfo::setCorpId, authCorpInfo.getCorpid())
//                .with(QwCorpInfo::setPermanentCode, wePrementCodeDto.getPermanent_code())
//                .with(QwCorpInfo::setCorpName, authCorpInfo.getCorp_name())
//                .with(QwCorpInfo::setCorpType, authCorpInfo.getCorp_type())
//                .with(QwCorpInfo::setCorpSquareLogoUrl, authCorpInfo.getCorp_square_logo_url())
//                .with(QwCorpInfo::setCorpUserMax, authCorpInfo.getCorp_user_max())
//                .with(QwCorpInfo::setCorpAgentMax, authCorpInfo.getCorp_agent_max())
//                .with(QwCorpInfo::setVerifiedEndTime, authCorpInfo.getVerified_end_time())
//                .with(QwCorpInfo::setSubjectType, authCorpInfo.getSubject_type())
//                .with(QwCorpInfo::setCorpWxqrcode, authCorpInfo.getCorp_wxqrcode())
//                .with(QwCorpInfo::setCorpScale, authCorpInfo.getCorp_scale())
//                .with(QwCorpInfo::setCorpIndustry, authCorpInfo.getCorp_industry())
//                .with(QwCorpInfo::setCorpSubIndustry, authCorpInfo.getCorp_sub_industry())
//                .with(QwCorpInfo::setLocation, authCorpInfo.getLocation())
//                .with(QwCorpInfo::setCreateTime, DateUtil.dateToStamp(new Date()))
//                .with(QwCorpInfo::setUpdateTime, DateUtil.dateToStamp(new Date()))
//                .with(QwCorpInfo::setCorpFullName, authCorpInfo.getCorp_full_name())
//                .with(QwCorpInfo::setAgentId, authInfo.getAgent().get(0).getAgentid())
//                .build();
//        corpService.insertOrUpdate(corpInfo);
//        log.error("更新或者注册后的授权企业信息 : {}", JSONUtil.toJsonStr(corpInfo));
//        //TODO 企业信息入库等操作
//        AuthUserInfoDto authUserInfo = wePrementCodeDto.getAuth_user_info();
//        String userid = authUserInfo.getUserid();
//        List<QwUserInfo> users = userService.selectList(new EntityWrapper<QwUserInfo>().eq("user_id", userid).eq("status", 1));
//        Integer uid = null;
//        if (CollectionUtils.isNotEmpty(users)) {
//            uid = users.get(0).getId();
//        }
//        QwUserInfo qwUserInfo = Builder.of(QwUserInfo::new)
//                .with(QwUserInfo::setId, uid)
//                .with(QwUserInfo::setUserId, userid)
//                .with(QwUserInfo::setName, authUserInfo.getName())
//                .with(QwUserInfo::setAvatar, authUserInfo.getAvatar())
//                .build();
//        userService.insertOrUpdate(qwUserInfo);
//        log.error("授权企业安装应用更新或者添加企业管理员信息 : {}", JSONUtil.toJsonStr(qwUserInfo));
    }
}
