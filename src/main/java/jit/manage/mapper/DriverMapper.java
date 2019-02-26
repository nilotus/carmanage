package jit.manage.mapper;

import jit.manage.pojo.Driver;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Mapper
public interface DriverMapper {
    @Select("select * from driver where LN = #{LN}")
    Driver select(@Param("LN") String LN);

    @Insert("INSERT INTO driver(LN,Name, Sex, Age, Phone, LK) VALUES(#{LN},#{Name}, #{Sex}, #{Age}, #{Phone}, #{LK})")
    boolean insert(Driver driver);

    @Delete("DELETE FROM driver where LN = #{LN}")
    boolean delete(@Param("LN") String LN);

    @Select("select * from driver")
    List<Driver> selectAll();
}
