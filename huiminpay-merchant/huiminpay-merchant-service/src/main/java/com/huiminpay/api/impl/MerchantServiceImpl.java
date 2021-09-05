package com.huiminpay.api.impl;

import com.huiminpay.api.MerchantService;
import com.huiminpay.api.dto.MerchantDto;
import com.huiminpay.bean.Merchant;
import com.huiminpay.mapper.MerchantMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public Merchant queryUserById(Long id) {
        return merchantMapper.selectById(id);
    }

    @Override
    public MerchantDto createMerchant(MerchantDto merchantDto) {
        Merchant merchant = new Merchant();
        merchant.setAuditStatus("0");
        merchant.setMobile(merchantDto.getMobile());
        merchantMapper.insert(merchant);
        merchantDto.setId(merchant.getId());
        return merchantDto;
    }
}
