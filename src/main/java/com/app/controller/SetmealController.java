package com.app.controller;


import com.app.entity.*;
import com.app.service.CheckitemService;
import com.app.service.SetmealService;
import com.app.service.SetmealdetailedService;
import com.app.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/setmeal")
public class SetmealController {
    Result result;
    @Autowired
    SetmealService setmealService;
    @Autowired
    SetmealdetailedService setmealdetailedService;
    @Autowired
    CheckitemService checkitemService;
    @RequestMapping("/getAll")
    public Result<List<Setmeal>> getAll(){
        List<Setmeal> setmealList = setmealService.list();//所有体检套餐
        setmealList.forEach(sm->{
            QueryWrapper<Setmealdetailed> qw= new QueryWrapper<>();
            qw.eq( "sm_id",sm.getSmId());
            List<Setmealdetailed> smdlist = setmealdetailedService.list(qw);
            List<Integer> ciIds = smdlist.stream().map(smd -> smd.getCiId()).collect(Collectors.toList());
            List<Checkitem> checkitemList = checkitemService.listByIds(ciIds);
            sm.setCheckItemList(checkitemList);
        });
        return result.ok(setmealList);
    }
}
