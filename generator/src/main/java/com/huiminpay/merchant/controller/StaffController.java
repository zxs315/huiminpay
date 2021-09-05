package com.huiminpay.merchant.controller;


import com.huiminpay.merchant.service.IStaffService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@Slf4j
@Controller
@Api(value = "", tags = "", description="")
public class StaffController {

    @Autowired
    private IStaffService staffService;
}
