package com.lovesh.controller;

import com.lovesh.dto.Result;
import com.lovesh.entity.User;
import com.lovesh.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping(value = "getAllUser")
    @ResponseBody
    public Result<List<User>> getAllUser(){
        return new Result<>(200, true, iUserService.getAllUser());
    }
}
