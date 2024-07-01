package com.app.controller;


import com.app.entity.Hospital;
import com.app.entity.Users;
import com.app.service.HospitalService;
import com.app.util.Result;
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
@RequestMapping("/hospital")
public class HospitalController {
    Result result;
    @Autowired
    HospitalService hospitalService;
    @RequestMapping("/getAll")
    public Result<List<Hospital>> getAll(){
        return result.ok(hospitalService.getUserAll());
    }
}
