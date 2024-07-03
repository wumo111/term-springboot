package com.app.service.impl;

import com.app.entity.Hospital;
import com.app.entity.Orders;
import com.app.entity.request.CheckAvailabilityDto;
import com.app.entity.response.AvailabilityVo;
import com.app.entity.response.OrderCountByDateVO;
import com.app.mapper.OrdersMapper;
import com.app.service.CalendarService;
import com.app.service.HospitalService;
import com.app.service.OrdersService;
import com.app.util.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Byterain
 * @since 2024-06-29
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    public List<Map<String, Object>> getAllOrders() {
        return ordersMapper.getAllOrders();
    }
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    CalendarService calendarService;

    @Override
    public Result<AvailabilityVo> checkAvailability(CheckAvailabilityDto dto) {
        //查询医院每周 周预约安排。
        Hospital hospital = hospitalService.getById(dto.getHpId());  //查询App选择体检医院数据。
        String rule = hospital.getRule();  //rule数据就是 200,100,100,100,100,100,200
        Map<Integer, Integer> weekAvailability = parseRuleToMap(rule);
        LocalDate nowDate = LocalDate.now();
        Map<LocalDate, Integer> availability = initAvailability(nowDate, weekAvailability);

        dto.setEndDate(dto.getStartDate().plusDays(30));
        CheckAvailabilityDto temp = new CheckAvailabilityDto();
        BeanUtils.copyProperties(dto,temp);
        temp.setStartDate(nowDate);

        List<OrderCountByDateVO> odcList = ordersMapper.selectOrderCountByDateRange(temp);
        System.out.println( availability);;
        System.out.println(odcList);
        for (OrderCountByDateVO ocd : odcList){
            //odc包含一个日期 和该日期 实际下单量
            //availability Map<日期,200>集合存储是当月每天 医院开发 体检订单数量 默认200
            //getOrDefault() 按照key查找值，没有返回默认值 0。
            Integer num = availability.getOrDefault(ocd.getOrderDate(),0);  //num 就是这天开发的订单数 200



            availability.put(ocd.getOrderDate(), num - ocd.getOrderCount());
        }

        //构建万年历
        int year = dto.getStartDate().getYear();
        int month = dto.getStartDate().getMonthValue();

        AvailabilityVo availabilityVo = calendarService.getAvailability(year, month);

        for(AvailabilityVo.DayAvailability d :availabilityVo.getDays()){
            LocalDate date = d.getDate();
            Integer count = availability.get(date);
            if(count==null || count <0){
                d.setOpen(false);
            }else{
                d.setOpen(true);
                d.setRemainingSlots(count);
            }
        }

        return Result.ok(availabilityVo);
    }

    public Map<LocalDate,Integer> initAvailability(LocalDate dateDto,Map<Integer,Integer> weekAvailability){
        Map<LocalDate,Integer> availability = new HashMap<>();
        LocalDate startDate = dateDto;
        LocalDate endDate = dateDto.plusDays(30);

        while(!startDate.isAfter(endDate)){
            DayOfWeek dayOfWeek = startDate.getDayOfWeek();   //星期几英文单词字符数据
            int weekValue = dayOfWeek.getValue();   //星期二  2     星期日 7
            weekValue = (weekValue==7)?0:weekValue;

            Integer count = weekAvailability.get(weekValue);  //取出对应天数 可以预约的订单数量
            availability.put(startDate,count);

            startDate = startDate.plusDays(1);
        }
        return availability;   //返回Map集合  key 日期 -value 订单
    }

    //将医院存储规则 rule 数据转化为一个Map集合
    public static Map<Integer,Integer> parseRuleToMap(String rule){
        //200,100,100,100,100,100,200
        //0 ,0
        //1 100
        String[] num = rule.split(",");
        Map<Integer,Integer> weekAvailability = new HashMap<>();
        for(int i=0;i<num.length;i++){
            //List 单列集合，存储使用方法 add(值);
            //Map集合 双列集合，键和值 put(key,value)
            //i 就是星期几，0星期日。
            weekAvailability.put(i,Integer.parseInt(num[i]));
        }
        return weekAvailability;
    }
}
