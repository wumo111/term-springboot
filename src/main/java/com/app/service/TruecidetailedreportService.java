package com.app.service;

import com.app.entity.Truecidetailedreport;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Byterain
 * @since 2024-07-03
 */
public interface TruecidetailedreportService extends IService<Truecidetailedreport> {
    public void deleteBy(Integer orderId, Integer ciId);
}
