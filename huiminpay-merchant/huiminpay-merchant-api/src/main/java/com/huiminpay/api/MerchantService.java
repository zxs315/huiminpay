package com.huiminpay.api;

import com.huiminpay.api.dto.MerchantDto;
import com.huiminpay.bean.Merchant;

public interface MerchantService {
    public Merchant queryUserById(Long id);

    /**
     * 创建用户
     * @param merchantDto
     * @return
     */
    MerchantDto createMerchant(MerchantDto merchantDto);
}
