package com.app.service;

import com.app.entity.Checkitemdetailed;
import com.app.entity.response.CiDetailedReportVo;
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
public interface CheckitemdetailedService extends IService<Checkitemdetailed> {
    public List<CiDetailedReportVo> getCiDetailedReportsByOrderId(int orderId);
}
