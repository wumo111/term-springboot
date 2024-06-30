package com.app.mapper;

import com.app.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Byterain
 * @since 2024-06-29
 */
public interface UsersMapper extends BaseMapper<Users> {
    int insertUser(Users users);
}
