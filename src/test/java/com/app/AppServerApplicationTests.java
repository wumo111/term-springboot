package com.app;

import com.app.entity.Users;
import com.app.service.UsersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AppServerApplicationTests {
    @Autowired

    UsersService usersService;

    @Test
    void contextLoads() {
        QueryWrapper<Users> qw = new QueryWrapper<>();
        qw.like("user_id", "1");
        List<Users> list = usersService.list(qw);
        System.out.println(list);
    }
}
