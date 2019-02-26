package jit.manage.mapper;

import jit.manage.pojo.Station;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Mapper
public interface StationMapper {
    @Insert("INSERT INTO station (RouteId,Place,Time) VALUES (#{RouteId},#{Place},#{Time})")
    boolean insert(Station station);
    @Select("select * from station")
    List<Station> selectAll();
}
