package com.huiminpay.controller;

import com.huiminpay.api.MerchantService;
import com.huiminpay.api.dto.MerchantDto;
import com.huiminpay.api.lSmsService;
import com.huiminpay.bean.Merchant;
import com.huiminpay.vo.MerchantVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@Api("商铺应用API接口")
@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Reference
    private MerchantService merchantService;
    @Reference
    private lSmsService lSmsService;

    @ApiOperation(value = "根据商铺ID获取商铺信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "merchantId", value = "商铺id", required = true, dataType = "long")
    })
    @GetMapping("/queryMerchantById/{merchantId}")
    public Merchant queryMerchantById(@PathVariable("merchantId") Long id) {
        return merchantService.queryUserById(id);
    }

    /**
     * 获取验证码
     * @param phone
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "path")
    })
    @GetMapping("/sendSms/{phone}")
    public String sendSms(@PathVariable("phone") String phone) {

        String sms = lSmsService.sendSms(phone);
        return sms;
    }


    @PostMapping("/register")
    public MerchantVo registerMerchant(@RequestBody MerchantVo merchantVo) {

        //校验验证码
        lSmsService.verify(merchantVo.getVerifiykey(), merchantVo.getVerifiyCode());
        //用户注册
        MerchantDto merchantDto = new MerchantDto();
        merchantDto.setMobile(merchantVo.getMobile());
        merchantService.createMerchant(merchantDto);
        return merchantVo;
    }
}
