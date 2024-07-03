package com.app.entity.response;

import lombok.Data;

@Data
public class CiDetailedItem {

    private int cdId;
    private String name;
    private String unit;
    private double minRange;
    private double maxRange;
    private String normalValueString;
    private int type;
    private double value;
    private boolean siError;
    private String remarks;
}
