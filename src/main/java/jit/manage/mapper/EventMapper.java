package jit.manage.mapper;

import jit.manage.Dto.EventDto;
import jit.manage.pojo.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Mapper
public interface EventMapper {
    @Insert("INSERT INTO eventrecord (CarNumber,EventTime,EventPlace,EventKind,DriverIN,EventReason,EventInfo) VALUES(#{carNumber},#{eventTime},#{eventPlace},#{eventKind},#{driverIN},#{eventReason},#{eventInfo})")
    boolean add (Event event);

    @Select("select * from eventrecord limit #{limit} offset #{page}")
    List<Event> selectAll(@Param("page") int page, @Param("limit") int limit);

    @Select("select COUNT(EventId) FROM eventrecord")
    int count();

    @Select("<script>"
            + "SELECT COUNT(EventId) FROM eventrecord where 1=1"
            + "<if test = 'carNumber !=\"\"'>"
            + "and CarNumber = #{carNumber}"
            +"</if>"
            + "<if test = 'eventKind !=\"\"'>"
            + "and EventKind = #{eventKind}"
            +"</if>"
            + "<if test = 'st !=\"\" and et !=\"\" '>"
            + "and EventTime BETWEEN #{st} AND #{et}"
            +"</if>"
            + "LIMIT #{limit} OFFSET #{page}"
            +"</script>")
    int count2();

    @Select("<script>"
            + "SELECT * FROM eventrecord where 1=1"
            + "<if test = 'carNumber !=\"\"'>"
            + "and CarNumber = #{carNumber}"
            +"</if>"
            + "<if test = 'eventKind !=\"\"'>"
            + "and EventKind = #{eventKind}"
            +"</if>"
            + "<if test = 'st !=\"\" and et !=\"\" '>"
            + "and EventTime BETWEEN #{st} AND #{et}"
            +"</if>"
            + "LIMIT #{limit} OFFSET #{page}"
            +"</script>")
    List<Event> find(EventDto dto);
}
