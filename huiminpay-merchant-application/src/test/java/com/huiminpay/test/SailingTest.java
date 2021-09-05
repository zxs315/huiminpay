package com.huiminpay.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SailingTest {

    @Test
    public void createTest() {
        //创建RestTemplate进行远程调用
        RestTemplate restTemplate = new RestTemplate();
        //定义请求路径
        String url = "http://127.0.0.1:56085/sailing/generate?effectiveTime=60&name=sms";
        String phone = "18838194989";

        HashMap<String, Object> body = new HashMap<>();
        body.put("mobile", phone);

        //指定请求路径的格式json
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        //将发送的信息设置到请求头中进行发送
        HttpEntity<HashMap<String, Object>> httpEntity = new HttpEntity<>(body, httpHeaders);

        ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        Map map = exchange.getBody();
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
