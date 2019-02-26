package jit.manage.mapper;

import jit.manage.pojo.Route;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Mapper
public interface RouteMapper {
    @Insert("INSERT INTO routerecord (CarNumber,StartTime,StartPlace,EndTime,Destination,DriverIN,State,Cost) VALUES(#{CarNumber},#{StartTime},#{StartPlace},#{EndTime},#{Destination},#{DriverIN},#{State},#{Cost})")
    boolean insert(Route route);
    @Select("select * from routerecord")
    List<Route> selectAll();
}
