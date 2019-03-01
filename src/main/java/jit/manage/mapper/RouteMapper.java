package jit.manage.mapper;

import jit.manage.Dto.RouteDto;
import jit.manage.pojo.Route;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Mapper
public interface RouteMapper {
    @Insert("INSERT INTO routerecord (CarNumber,StartTime,StartPlace,EndTime,Destination,DriverIN,State,Cost) VALUES(#{carNumber},#{st},#{startPlace},#{et},#{destination},#{driverIN},#{state},#{cost})")
    boolean add(Route route);

    @Select("select * from routerecord limit #{limit} offset #{page}")
    List<Route> selectAll(@Param("page") int page, @Param("limit") int limit);

    @Select("select COUNT(RouteId) FROM routerecord")
    int count();

    @Select("<script>"
            + "SELECT COUNT(RouteId) FROM routerecord where 1=1"
            + "<if test = 'carNumber !=\"\"'>"
            + "and CarNumber = #{carNumber}"
            +"</if>"
            + "<if test = 'driverIN !=\"\"'>"
            + "and DriverIN = #{driverIN}"
            +"</if>"
            + "<if test = 'state !=\"\"'>"
            + "and State = #{state}"
            +"</if>"
            + "<if test = 'st !=\"\" and et !=\"\" '>"
            + "and StartTime BETWEEN #{st} AND #{et}"
            +"</if>"
            +"</script>")
    int count2();

    @Select("<script>"
            + "SELECT * FROM routerecord where 1=1"
            + "<if test = 'carNumber !=\"\"'>"
            + "and CarNumber = #{carNumber}"
            +"</if>"
            + "<if test = 'driverIN !=\"\"'>"
            + "and DriverIN = #{driverIN}"
            +"</if>"
            + "<if test = 'state !=\"\"'>"
            + "and State = #{state}"
            +"</if>"
            + "<if test = 'st !=\"\" and et !=\"\" '>"
            + "and StartTime BETWEEN #{st} AND #{et}"
            +"</if>"
            + "LIMIT #{limit} OFFSET #{page}"
            +"</script>")
    List<Route> find(RouteDto dto);
}
