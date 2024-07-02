package com.app.entity.response;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
@Data
public class AvailabilityVo {
    private int year;
    private int month;
    private List<DayAvailability> days;
    //内部类
    @Data
    public static class DayAvailability{
        private LocalDate date; //当月日期
        private boolean open; //这天是否可以预约。
        private int remainingSlots; //剩余预约量
    }
}