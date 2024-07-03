package com.app.controller;


import com.app.entity.response.CiDetailedReportVo;
import com.app.service.CheckitemdetailedService;
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
 * @since 2024-07-01
 */
@RestController
@RequestMapping("/checkitemdetailed")
public class CheckitemdetailedController {
    @Autowired
    public CheckitemdetailedService orderService;
    private Result result;

    @GetMapping("/getCiDetailedReportsByOrderId")
    public Result<List<CiDetailedReportVo>> getCiDetailedReportsByOrderId(@RequestParam("orderId") int orderId) {
        return result.ok(orderService.getCiDetailedReportsByOrderId(orderId));
    }

}
