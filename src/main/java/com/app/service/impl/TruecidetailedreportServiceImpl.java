package com.app.service.impl;

import com.app.entity.Truecidetailedreport;
import com.app.mapper.TruecidetailedreportMapper;
import com.app.service.TruecidetailedreportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Byterain
 * @since 2024-07-03
 */
@Service
public class TruecidetailedreportServiceImpl extends ServiceImpl<TruecidetailedreportMapper, Truecidetailedreport> implements TruecidetailedreportService {
    @Autowired
    TruecidetailedreportMapper Mapper;
    public void deleteBy(Integer orderId, Integer ciId){
        Mapper.deleteBy(orderId, ciId);
    }
}
