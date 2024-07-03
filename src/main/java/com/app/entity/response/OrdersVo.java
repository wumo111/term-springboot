package com.app.entity.response;

import lombok.Data;

import java.util.List;
@Data
public class OrdersVo {
    private String orderId;
    private List<CiDetailedReportVo> ciDetailedReport;
}
