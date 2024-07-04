package com.app.controller;


import com.app.entity.Users;
import com.app.service.UsersService;
import com.app.util.MD5Utils;
import com.app.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("/getById")
    public Result<Users> getById(@RequestParam String userId) {
        return result.ok(usersService.getById(userId));
    }
    @PostMapping("/login")
    public Result login(@RequestBody Users users) {
        Users one = usersService.getById(users.getUserId());
        if (one == null) {
            return Result.error(1001, "没有查询到该用户");
        } else {
            if (one.getPassword().equals(
                    MD5Utils.md5(MD5Utils.inputPassToNewPass(users.getPassword())) )) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", users.getUserId());
                claims.put("name", users.getRealName());
                String jwt = com.example.qiuqiul.util.JwtUtils.generateJwt(claims);
                return Result.ok(jwt);
            } else {
                return Result.error(1002, "输入的密码不正确");
            }
        }
    }
    @PostMapping("/register")
    public Result register(@RequestBody Users users) {
        users.setUserType(1);
        String newPass =
                MD5Utils.md5(MD5Utils.inputPassToNewPass(users.getPassword()));
        users.setPassword(newPass);
        try {
            usersService.register(users);
            if(users.getUserId().length()==11&&users.getIdentityCard().length()==18)
                return Result.ok();
            else return Result.error(1003, "手机或身份证输入有问题");
        } catch (Exception e) {
            System.out.println(e);
            return Result.error(1003, "注册失败");
        }
    }
}
