package com.app.entity.response;

import lombok.Data;

import java.util.List;

@Data

public class CiDetailedReportVo {
    private int ciId;
    private String ciName;
    private String title;
    private String content;
    private List<CiDetailedItem> items;

}
