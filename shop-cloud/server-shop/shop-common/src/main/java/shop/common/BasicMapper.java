package shop.common;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自定义通用mapper
 * bean定义时可变泛型必须明确,而该接口为泛型接口，故扫描时排除该接口
 * @author mingzhi.xie
 * @date 2019/7/5
 * @since 1.0
 */
public interface BasicMapper<T> extends Mapper<T>, ConditionMapper<T>, IdsMapper<T>, MySqlMapper<T> {

}
