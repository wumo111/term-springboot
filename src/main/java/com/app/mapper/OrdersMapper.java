package com.app.mapper;

import com.app.entity.Orders;
import com.app.entity.request.CheckAvailabilityDto;
import com.app.entity.response.OrderCountByDateVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Byterain
 * @since 2024-06-29
 */
public interface OrdersMapper extends BaseMapper<Orders> {
    @MapKey("orderId")
    List<Map<String, Object>> getAllOrders();

    @Select("select DATE(order_date) as orderDate,COUNT(*) as orderCount from orders where hp_id =#{dto.hpId} and sm_id =#{dto.smId} and order_date BETWEEN #{dto.startDate} AND #{dto.endDate} GROUP BY DATE(order_date)")
    List<OrderCountByDateVO> selectOrderCountByDateRange(@Param("dto") CheckAvailabilityDto dto);

    Map<String, Object> getByOrderId(String orderId);
    @MapKey("orderId")

    List<Map<String, Object>> getAllByUserId(String userId);

    @Select("SELECT * FROM orders WHERE hp_Id = #{hpId} AND sm_Id = #{smId} AND order_Date = #{orderDate} AND user_Id = #{userId}")
    Orders getByHpIdAndSmIdAndOrderDate(@Param("hpId") Integer hpId, @Param("smId") Integer smId, @Param("orderDate") LocalDate orderDate,@Param("userId") String userId);
}
