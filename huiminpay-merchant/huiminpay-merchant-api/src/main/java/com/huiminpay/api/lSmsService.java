package com.huiminpay.api;

/**
 * 验证码接口
 */
public interface lSmsService {

    /**
     * 获取验证码
     * @param phone
     * @return
     */
    public String sendSms(String phone);

    /**
     * 验证码校验
     * @param verifyKey
     * 验证码Key值由前端传递
     * @param verifyCode
     * 验证码，由用户输入
     * @return
     */
    public String verify(String verifyKey,String verifyCode);
}
