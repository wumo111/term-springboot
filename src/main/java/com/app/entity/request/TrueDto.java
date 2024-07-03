package com.app.entity.request;

import com.app.entity.Truecidetailedreport;
import lombok.Data;

import java.util.List;

@Data
public class TrueDto {
        private Integer orderId;
        private List<Truecidetailedreport> item;
}
