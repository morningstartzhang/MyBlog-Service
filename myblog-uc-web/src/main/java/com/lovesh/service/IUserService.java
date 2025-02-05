package com.lovesh.service;

import com.lovesh.entity.User;

import java.util.List;

/**
 * @author zdm
 * @date 2023/09/08
 */
public interface IUserService {
    /**
     * 获取所有用户
     *
     * @return {@link List}<{@link User}>
     */
    List<User> getAllUser();
}
