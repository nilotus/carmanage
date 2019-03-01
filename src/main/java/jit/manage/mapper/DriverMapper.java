package jit.manage.mapper;

import jit.manage.Dto.DriverDto;
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

    @Insert("INSERT INTO driver(LN,Name, Sex, Age, Phone, LK) VALUES(#{LN},#{name}, #{sex}, #{age}, #{phone}, #{LK})")
    boolean add(Driver driver);

    @Delete("DELETE FROM driver where LN = #{LN}")
    boolean delete(@Param("LN") String LN);

    @Select("select * from driver limit #{limit} offset #{page}")
    List<Driver> selectAll(@Param("page") int page,@Param("limit") int limit);

    @Select("select COUNT(LN) FROM driver")
    int count();

    @Select("<script>"
            + "select COUNT(LN) FROM driver where 1=1"
            + "<if test = 'LN !=\"\" and LN !=null'>"
            + "and LN = #{LN}"
            +"</if>"
            + "<if test = 'LK !=\"\" and LK !=null'>"
            + "and LK = #{LK}"
            +"</if>"
            +"</script>")
    int count2(DriverDto dto);

    @Select("<script>"
            + "SELECT * FROM driver where 1=1"
            + "<if test = 'LN !=\"\"'>"
            + "and LN = #{LN}"
            +"</if>"
            + "<if test = 'LK !=\"\"'>"
            + "and LK = #{LK}"
            +"</if>"
            + "LIMIT #{limit} OFFSET #{page}"
            +"</script>")
    List<Driver> find(DriverDto dto);

}
