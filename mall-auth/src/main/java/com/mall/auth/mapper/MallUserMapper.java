package com.mall.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.auth.model.po.MallUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author joker
 * @since 2023-02-06
 */
@Mapper
public interface MallUserMapper extends BaseMapper<MallUser> {

}
