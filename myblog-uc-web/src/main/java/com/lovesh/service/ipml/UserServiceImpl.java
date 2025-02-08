package com.lovesh.service.ipml;

import com.lovesh.dao.UserMapper;
import com.lovesh.entity.User;
import com.lovesh.service.IUserService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zdm
 * @date 2023/09/08
 */
@Component
public class UserServiceImpl implements IUserService {


    private final UserMapper userMapper;


    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }
}
