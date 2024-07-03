package com.app.entity.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckAvailabilityDto {
    private Integer smId;  //体检套餐id
    private Integer hpId;   //体检医院id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}