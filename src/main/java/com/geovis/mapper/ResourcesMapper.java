package com.geovis.mapper;

import com.geovis.entity.Resources;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhouxian
 * @since 2018-12-24
 */
@Component
@Mapper
public interface ResourcesMapper extends BaseMapper<Resources> {

}