package com.app.controller;


import com.app.entity.Orders;
import com.app.entity.Users;
import com.app.service.OrdersService;
import com.app.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Byterain
 * @since 2024-06-29
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    Result result;
    @Autowired
    OrdersService service;
    @RequestMapping("/getAll")
    public Result<List<Orders>> getAll() {
        QueryWrapper<Orders> qw = new QueryWrapper<>();
        qw.like("user_id", "1");
        List<Orders> list = service.list(qw);
        return result.ok(list);
    }
}
