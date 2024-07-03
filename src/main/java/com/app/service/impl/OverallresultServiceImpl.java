package com.app.service.impl;

import com.app.entity.Overallresult;
import com.app.mapper.OverallresultMapper;
import com.app.service.OverallresultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    OverallresultMapper overallresultMapper;
    public List<Overallresult> loading(String orderId) {
        if (overallresultMapper.loading(orderId) == null){
            System.out.println("No data found");
            return null;
        }
        else return overallresultMapper.loading(orderId);
    }
}
