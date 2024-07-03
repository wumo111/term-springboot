package com.app.mapper;

import com.app.entity.Checkitemdetailed;
import com.app.entity.response.CiDetailedReportVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Byterain
 * @since 2024-07-01
 */
public interface CheckitemdetailedMapper extends BaseMapper<Checkitemdetailed> {
    List<CiDetailedReportVo> getCiDetailedReportsByOrderId(@Param("orderId") int orderId);
}
