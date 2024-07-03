package com.app.controller;


import com.app.entity.Overallresult;
import com.app.entity.Truecidetailedreport;
import com.app.entity.request.TrueDto;
import com.app.service.TruecidetailedreportService;
import com.app.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Byterain
 * @since 2024-07-03
 */
@RestController
@RequestMapping("/truecidetailedreport")
public class TruecidetailedreportController {
    @Autowired
    TruecidetailedreportService truecidetailedreportService;
    Result result;
    @RequestMapping("/add")
    public Result add(@RequestBody TrueDto wrapper){
        Integer orderId = wrapper.getOrderId();
        List<Truecidetailedreport> items = wrapper.getItem();

        items.forEach(item -> {
            item.setOrderId(orderId); // Set orderId for each item
            truecidetailedreportService.deleteBy(item.getOrderId(), item.getCdId());
            truecidetailedreportService.save(item);
        });

        return result.ok();
    }

}
