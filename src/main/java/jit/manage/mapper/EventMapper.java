package jit.manage.mapper;

import jit.manage.pojo.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Mapper
public interface EventMapper {
    @Insert("INSERT INTO eventrecord (CarNumber,EventTime,EventPlace,EventKind,DriverIN,EventReason,EventInfo) VALUES(#{CarNumber},#{EventTime},#{EventPlace},#{EventKind},#{DriverIN},#{EventReason},#{EventInfo})")
    boolean insert (Event event);
    @Select("select * from eventrecord")
    List<Event> selectAll();
}
