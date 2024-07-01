package com.app.service.impl;

import com.app.entity.Hospital;
import com.app.entity.Users;
import com.app.mapper.HospitalMapper;
import com.app.service.HospitalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Byterain
 * @since 2024-06-29
 */
@Service
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements HospitalService
{
    @Autowired
    HospitalMapper hospitalMapper;
    public List<Hospital> getUserAll(){
        return hospitalMapper.selectList(null);
    }
}
