package jit.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by sunlotus on 2019/3/27.
 */
@Mapper
public interface MapMapper {
    @Select("select distance from map where sp = #{sp} and ep = #{ep}")
     int getdistance(@Param("sp")String sp,@Param("ep")String ep);
}
