package com.lovesh.dao;


import com.lovesh.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> getAllUser();
}
