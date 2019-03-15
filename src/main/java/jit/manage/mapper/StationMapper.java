package jit.manage.mapper;

import jit.manage.Dto.StationDto;
import jit.manage.pojo.Station;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Mapper
public interface StationMapper {
    @Insert("INSERT INTO station (RouteId,Place,Time) VALUES (#{routeld},#{place},#{time})")
    boolean insert(Station station);

    @Select("select * from station")
    List<Station> selectAll();

    @Select("SELECT r.RouteId,r.CarNumber,r.DriverIN,d.`Name`,r.StartPlace,r.StartTime,s.Place,s.Time from routerecord r,driver d,station s WHERE d.LN = r.DriverIN AND r.RouteId=s.RouteId AND r.RouteId = #{id} ORDER BY s.Time")
    List<StationDto> route(String id);

    @Select("SELECT RouteId from routerecord WHERE State = 1")
    String[] select1();

}
