package com.app.service;

import com.app.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Byterain
 * @since 2024-06-29
 */
public interface UsersService extends IService<Users> {
    public List<Users> getUserAll();
    public void register(Users users);
}
