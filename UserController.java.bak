package com.offcn.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.offcn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @ResponseBody
    @RequestMapping("showname")
    public String showName(){
       return userService.getName();
    }

}
