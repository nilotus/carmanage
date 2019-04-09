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

    @Select("select * from routerecord where State='1' or State =0 limit #{limit} offset #{page}")
    List<Route> select1(@Param("page") int page, @Param("limit") int limit);

    @Select("SELECT * from routerecord WHERE State = 3 OR State = 2 limit #{limit} offset #{page}")
    List<Route> select2(@Param("page") int page, @Param("limit") int limit);

    @Select("select COUNT(RouteId) FROM routerecord where State='2' or State =3" )
    int count23();

    @Select("select COUNT(RouteId) FROM routerecord")
    int count();

    @Select("select COUNT(RouteId) FROM routerecord where State='1' or State =0" )
    int count1();

    @Update("update routerecord set Cost = #{cost} where RouteId = #{id}")
    boolean cost(@Param("id")String id,@Param("cost")String cost);

    @Update("update routerecord set State = 3,EndTime =#{time} where RouteId = #{id}")
    boolean state(@Param("id")String id,@Param("time")String time);

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

    //近一年行程短于1天的
    @Select("SELECT COUNT(RouteId) FROM routerecord WHERE State =2 AND (EndTime-StartTime)<1000000 ")
    int counta();
    //近一年行程1-3天的
    @Select("SELECT COUNT(RouteId) FROM routerecord WHERE State =2 AND (EndTime-StartTime)>=1000000 AND (EndTime-StartTime)<3000000")
    int countb();
    //近一年行程3-7天的
    @Select("SELECT COUNT(RouteId) FROM routerecord WHERE State =2 AND (EndTime-StartTime)>=3000000 AND (EndTime-StartTime)<7000000")
    int countc();
    //近一年行程长于7天的
    @Select("SELECT COUNT(RouteId) FROM routerecord WHERE State =2 AND (EndTime-StartTime)>=7000000")
    int countd();

    //消费低于100
    @Select("SELECT count(RouteId) from routerecord WHERE Cost <=200")
    int counta1();

    @Select("SELECT count(RouteId) from routerecord WHERE Cost >200 and Cost<=400")
    int countb1();

    @Select("SELECT count(RouteId) from routerecord WHERE Cost >400 and Cost<=600")
    int countc1();

    @Select("SELECT count(RouteId) from routerecord WHERE Cost >600 and Cost<=800")
    int countd1();

    @Select("SELECT count(RouteId) from routerecord WHERE Cost >800 and Cost<=1000")
    int counte1();

    @Select("SELECT count(RouteId) from routerecord WHERE Cost >1000 and Cost<=1200")
    int countf1();

    @Select("SELECT count(RouteId) from routerecord WHERE Cost >1200")
    int countg1();

}
