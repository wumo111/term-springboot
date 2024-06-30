package com.app.service.impl;

import com.app.entity.Users;
import com.app.mapper.UsersMapper;
import com.app.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Byterain
 * @since 2024-06-29
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Autowired
    UsersMapper usersMapper;
    public List<Users> getUserAll(){
        return usersMapper.selectList(null);
    }
    @Override
    public void register(Users users) {
        usersMapper.insertUser(users);
    }

}
