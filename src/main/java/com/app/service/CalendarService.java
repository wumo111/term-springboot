package com.app.service;
import com.app.entity.response.AvailabilityVo;
import org.springframework.stereotype.Service;
//万年历接口

public interface CalendarService {
    public AvailabilityVo getAvailability(int year, int month);
}