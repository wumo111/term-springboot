package com.app.service.impl;

import com.app.entity.Overallresult;
import com.app.mapper.OverallresultMapper;
import com.app.service.OverallresultService;
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
public class OverallresultServiceImpl extends ServiceImpl<OverallresultMapper, Overallresult> implements OverallresultService {
    @Autowired
    OverallresultMapper overallresultMapper;
    @Override
    public List<Overallresult> loading(String orderId) {
         return overallresultMapper.loading(orderId);
    }
    @Override
    public void deleteByOrderIdAndTitle(Integer orderId, String title){
        overallresultMapper.deleteByOrderIdAndTitle(orderId, title);
    }
}
