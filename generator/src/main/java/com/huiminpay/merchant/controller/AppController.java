package com.huiminpay.merchant.controller;


import com.huiminpay.merchant.service.IAppService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Wy
 */
@Slf4j
@Controller
@Api(value = "", tags = "", description="")
public class AppController {

    @Autowired
    private IAppService appService;
}
