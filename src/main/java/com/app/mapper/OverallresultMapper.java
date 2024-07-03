package com.app.mapper;

import com.app.entity.Overallresult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Byterain
 * @since 2024-07-01
 */
public interface OverallresultMapper extends BaseMapper<Overallresult> {
    @Select("SELECT * FROM overallresult WHERE order_id = #{orderId}")

    List<Overallresult> loading(String orderId);
}
