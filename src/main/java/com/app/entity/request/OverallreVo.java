package com.app.entity.request;

import com.app.entity.Overallresult;
import lombok.Data;
import java.util.List;
@Data
public class OverallreVo {
    private Integer orderId;
    private List<Overallresult> item;
}
