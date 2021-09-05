package com.huiminpay.api.impl;

import com.alibaba.fastjson.JSON;
import com.huiminpay.api.lSmsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class lSmsServiceImpl implements lSmsService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${sms.url}")
    private String smsUrl;
    @Value("${sms.effectiveTime}")
    private String effectiveTime;

    @Override
    public String sendSms(String phone) {
        //定义请求路径
        String url = "http://127.0.0.1:56085/sailing/generate?effectiveTime=300&name=sms";

        HashMap<String, Object> body = new HashMap<>();
        body.put("mobile", phone);

        //指定请求路径的格式json
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        //将发送的信息设置到请求头中进行发送
        HttpEntity<HashMap<String, Object>> httpEntity = new HttpEntity<>(body, httpHeaders);

        ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        if (exchange != null) {
            Map map = exchange.getBody();
            Object object = map.get("result");
            if (object == null) {
                throw new RuntimeException("验证码获取失败");
            }
            Map<String, String> result = (Map<String, String>) object;
            String key = result.get("key");
            return key;
        }
        return null;
    }

    @Override
    public String verify(String verifyKey, String verifyCode) {
        String url = smsUrl + "/verify?name=sms&verificationCode=" + verifyCode + "&verificationKey=" + verifyKey;
        Map responseMap = null;
        try {
            //请求校验验证码
            ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.POST,
                    HttpEntity.EMPTY, Map.class);
            responseMap = exchange.getBody();
            System.out.println("校验验证码，响应内容："+JSON.toJSONString(responseMap));
        } catch (RestClientException e) {
            e.printStackTrace();
            System.out.println(e.getMessage()+":"+e);
            throw new RuntimeException("验证码错误");
        }
        if (responseMap == null || responseMap.get("result") == null || !(Boolean)
                responseMap.get("result")) {
            throw new RuntimeException("验证码错误");
        }

        return null;
    }
}
