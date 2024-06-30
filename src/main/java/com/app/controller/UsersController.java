package com.app.controller;


import com.app.entity.Users;
import com.app.service.UsersService;
import com.app.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Byterain
 * @since 2024-06-29
 */
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;
    Result result = new Result();
    @RequestMapping("/getall")
    public Result<List<Users>> getAll(){
        return result.ok(usersService.getUserAll());
    }
    @PostMapping("/login")
    public Result login(@RequestBody Users users) {
        Users one = usersService.getById(users.getUserId());
        if (one == null) {
            return Result.error(1001, "没有查询到该用户");
        } else {
            if (one.getPassword().equals(users.getPassword())) {
                return Result.ok("token_string");
            } else {
                return Result.error(1002, "输入的密码不正确");
            }
        }
    }
    @PostMapping("/register")
    public Result register(@RequestBody Users users) {
        users.setUserType(1);
        try {
            usersService.register(users);
            return Result.ok();
        } catch (Exception e) {
            System.out.println(e);
            return Result.error(1003, "注册失败");
        }
    }
}
