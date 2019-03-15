package jit.manage.mapper;

import jit.manage.Dto.RouteDto;
import jit.manage.pojo.Route;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Mapper
public interface RouteMapper {
    @Insert("INSERT INTO routerecord (CarNumber,StartTime,StartPlace,EndTime,Destination,DriverIN,State,Cost) VALUES(#{carNumber},#{startTime},#{startPlace},#{endTime},#{destination},#{driverIN},#{state},#{cost})")
    boolean add(Route route);

    @Select("select * from routerecord limit #{limit} offset #{page}")
    List<Route> selectAll(@Param("page") int page, @Param("limit") int limit);

    @Select("select * from routerecord where State='1' limit #{limit} offset #{page}")
    List<Route> select1(@Param("page") int page, @Param("limit") int limit);

    @Select("select COUNT(RouteId) FROM routerecord")
    int count();

    @Select("select COUNT(RouteId) FROM routerecord where State='1'" )
    int count1();

    @Update("update routerecord set State = 3 where RouteId = #{id}")
    boolean state(@Param("id")String id);

    @Update("update routerecord set State = 2,EndTime =#{time} where RouteId = #{id}")
    boolean state2(@Param("id")String id,@Param("time")String time);

    @Update("update routerecord set State = 1 where RouteId = #{id}")
    boolean state1(@Param("id")String id);

    @Select("select * from routerecord where RouteId = #{id}")
    Route selectbyId(@Param("id")String id);

    @Select("<script>"
            + "SELECT COUNT(RouteId) FROM routerecord where 1=1"
            + "<if test = 'carNumber !=\"\" and carNumber !=null'>"
            + "and CarNumber = #{carNumber}"
            +"</if>"
            + "<if test = 'driverIN !=\"\" and driverIN !=null'>"
            + "and DriverIN = #{driverIN}"
            +"</if>"
            + "<if test = 'state !=\"\" and state !=null'>"
            + "and State = #{state}"
            +"</if>"
            + "<if test = 'startTime !=\"\" and endTime !=\"\" and startTime != null and endTime !=null '>"
            + "and StartTime BETWEEN #{startTime} AND #{endTime}"
            +"</if>"
            +"</script>")
    int count2(RouteDto dto);

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
            + "<if test = 'startTime !=\"\" and endTime !=\"\" '>"
            + "and StartTime BETWEEN #{startTime} AND #{endTime}"
            +"</if>"
            + "LIMIT #{limit} OFFSET #{page}"
            +"</script>")
    List<Route> find(RouteDto dto);

    //近一年
}
