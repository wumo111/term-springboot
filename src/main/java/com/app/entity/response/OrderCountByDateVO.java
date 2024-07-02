package com.app.entity.response;
import lombok.Data;
import java.time.LocalDate;

@Data
public class OrderCountByDateVO {
    //订单预约日期"
    private LocalDate orderDate;
    //该日期下的所有预约量
    private Integer orderCount;
}