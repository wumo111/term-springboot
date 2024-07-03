package com.app.service.impl;

import com.app.entity.Checkitemdetailed;
import com.app.entity.response.CiDetailedReportVo;
import com.app.mapper.CheckitemdetailedMapper;
import com.app.service.CheckitemdetailedService;
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
 * @since 2024-07-01
 */
@Service
public class CheckitemdetailedServiceImpl extends ServiceImpl<CheckitemdetailedMapper, Checkitemdetailed> implements CheckitemdetailedService {

    @Autowired
    private  CheckitemdetailedMapper checkitemdetailedMapper;

    public List<CiDetailedReportVo> getCiDetailedReportsByOrderId(int orderId) {
        return checkitemdetailedMapper.getCiDetailedReportsByOrderId(orderId);
    }
}
