package com.lovesh.service.ipml;

import com.lovesh.dao.UserMapper;
import com.lovesh.entity.User;
import com.lovesh.entity.UserExample;
import com.lovesh.service.IUserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zdm
 * @date 2023/09/08
 */
@Component
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser(){
        return userMapper.selectByExample(new UserExample());
    }
}
