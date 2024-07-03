package com.app.controller;


import com.app.entity.Checkitem;
import com.app.entity.Overallresult;
import com.app.entity.Setmeal;
import com.app.entity.Setmealdetailed;
import com.app.service.OverallresultService;
import com.app.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Byterain
 * @since 2024-07-01
 */
@RestController
@RequestMapping("/overallresult")
public class OverallresultController {
    @Autowired
    OverallresultService overallresultService;
    Result result;
    @RequestMapping("/loading")
    public Result loading(@RequestParam String orderId){
        return result.ok(overallresultService.loading(orderId));
    }
}
