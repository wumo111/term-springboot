package com.app.service;

import com.app.entity.Hospital;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Byterain
 * @since 2024-06-29
 */
public interface HospitalService extends IService<Hospital> {
    public List<Hospital> getUserAll();
}
