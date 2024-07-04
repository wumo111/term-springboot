package com.app.service;

import com.app.entity.Orders;
import com.app.entity.request.CheckAvailabilityDto;
import com.app.entity.response.AvailabilityVo;
import com.app.util.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Byterain
 * @since 2024-06-29
 */
public interface OrdersService extends IService<Orders> {
    public List<Map<String, Object>> getAllOrders();
    public Result<AvailabilityVo> checkAvailability(CheckAvailabilityDto dto);

    public Map<String, Object> getByOrderId(String orderId);

    public List<Map<String, Object>> getAllById(String userId);

    public Orders getByHpIdAndSmIdAndOrderDate(Integer hpId, Integer smId, LocalDate parse,String userId);
}
