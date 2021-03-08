package com.jy.web;

import com.alibaba.fastjson.JSONObject;
import com.jy.bron.we.domain.vo.WxCpXmlMessageVO;
import com.jy.bron.we.service.WqEnterpriseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/wx/callback")
public class WeCallApi {

    @Resource
    WqEnterpriseService wqEnterpriseService;

    @PostMapping(value = "/recive", produces = {"application/xml;charset=UTF-8"})
    public String recive(@RequestBody String msg, @RequestParam(name = "msg_signature") String signature,
                         String timestamp, String nonce) {
        WxCpXmlMessageVO wxCpXmlMessageVO = wqEnterpriseService.recivePost(msg, signature, timestamp, nonce);
        return null;
    }

    @GetMapping(value = "/recive", produces = {"application/xml;charset=UTF-8"})
    public String recive(HttpServletRequest request) {
        String sVerifyMsgSig = request.getParameter("msg_signature");
        String sVerifyTimeStamp = request.getParameter("timestamp");
        String sVerifyNonce = request.getParameter("nonce");
        String sVerifyEchoStr = request.getParameter("echostr");
        return wqEnterpriseService.reciveGet(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
    }
}
