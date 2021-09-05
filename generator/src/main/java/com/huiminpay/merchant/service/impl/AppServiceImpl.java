package com.huiminpay.merchant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huiminpay.merchant.entity.App;
import com.huiminpay.merchant.mapper.AppMapper;
import com.huiminpay.merchant.service.IAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wy
 */
@Slf4j
@Service
@Transactional
public class AppServiceImpl extends ServiceImpl<AppMapper, App> implements IAppService {

}
