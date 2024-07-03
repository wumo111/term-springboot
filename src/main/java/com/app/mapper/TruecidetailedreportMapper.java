package com.app.mapper;

import com.app.entity.Truecidetailedreport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Byterain
 * @since 2024-07-03
 */
public interface TruecidetailedreportMapper extends BaseMapper<Truecidetailedreport> {
    @Delete("DELETE FROM truecidetailedreport WHERE order_id = #{orderId} AND cd_id = #{cdId}")
    void deleteBy(Integer orderId, Integer cdId);
}
