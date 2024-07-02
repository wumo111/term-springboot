package com.app.controller;


import com.app.entity.Orders;
import com.app.entity.Users;
import com.app.entity.request.CheckAvailabilityDto;
import com.app.service.OrdersService;
import com.app.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/orders")
public class OrdersController {
    Result result;
    @Autowired
    OrdersService orderservice;
    @RequestMapping("/getAllById")
    public Result<List<Orders>> getAll(@RequestParam String userId) {
        QueryWrapper<Orders> qw = new QueryWrapper<>();
        qw.eq("user_id", userId);
        List<Orders> list = orderservice.list(qw);
        return result.ok(list);
    }
    @RequestMapping("/recieveById")
    public Result recieveById(@RequestBody Orders orders) {
        orderservice.save(orders);
        return result.ok();
    }
    @RequestMapping("/turn1")
    public Result turn1(@RequestParam String orderId) {
        Orders orders=orderservice.getById(orderId);
        orders.setState(2);
        orderservice.updateById(orders);
        return result.ok();
    }
    @RequestMapping("/getAll")
    public Result<List<Map<String, Object>>> getAllOrders() {
        List<Map<String, Object>> orders = orderservice.getAllOrders();
        return result.ok(orders);
    }
    @RequestMapping("/checkAvailability")
    public Result checkAvailability(@RequestBody CheckAvailabilityDto dto){
        return orderservice.checkAvailability(dto);
    }
}
