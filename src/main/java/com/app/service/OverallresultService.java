package com.app.service;

import com.app.entity.Overallresult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Byterain
 * @since 2024-07-01
 */
public interface OverallresultService extends IService<Overallresult> {
    public List<Overallresult> loading(String orderId);

    public void deleteByOrderIdAndTitle(Integer orderId, String title);
}
