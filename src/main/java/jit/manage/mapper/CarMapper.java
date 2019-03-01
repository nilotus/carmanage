package jit.manage.mapper;

import jit.manage.Dto.CarDto;
import jit.manage.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Mapper
public interface CarMapper {
//    @Select("SELECT * FROM car WHERE CarNumber = #{cn}")
//    Car select(@Param("cn")String cn);

    @Insert("INSERT INTO car(CarNumber,CarKind,CarSeat,CarLoad,CarFactory,CarColor,CarState,CarOwner,CarON,Date) VALUES(#{CarNumber},#{CarKind},#{CarSeat},#{CarLoad},#{CarFactory},#{CarColor},#{CarState},#{CarOwner},#{CarON},#{date})")
    boolean add(Car car);

//    @Delete("DELECT FROM car WHERE CarNumber = #{cn}")
//    Boolean delete(@Param("cn")String cn);

    @Select("SELECT * FROM car limit #{limit} offset #{page}")
    List<Car> selectAll(@Param("page") int page,@Param("limit") int limit);

    @Select("select COUNT(CarNumber) FROM car")
    int count();

    @Select("<script>"
            + "SELECT COUNT(CarNumber) FROM car where 1=1"
            + "<if test = 'carNumber !=\"\"'>"
            + "and CarNumber = #{carNumber}"
            +"</if>"
            + "<if test = 'carKind !=\"\"'>"
            + "and CarKind = #{carKind}"
            +"</if>"
            + "<if test = 'st !=\"\" and et !=\"\" '>"
            + "and Date BETWEEN #{st} AND #{et}"
            +"</if>"
            + "LIMIT #{limit} OFFSET #{page}"
            +"</script>")
    int count2();

//    @Select("SELECT * FROM car WHERE CarNumber = #{arg0} and CarKind = #{param1} and Date BETWEEN #{param2} AND #{param3} limit #{limit} offset #{page}")
//    List<Car> change(CarDto dto,@Param("page") int page,@Param("limit") int limit);

    @Select("<script>"
            + "SELECT * FROM car where 1=1"
            + "<if test = 'carNumber !=\"\"'>"
            + "and CarNumber = #{carNumber}"
            +"</if>"
            + "<if test = 'carKind !=\"\"'>"
            + "and CarKind = #{carKind}"
            +"</if>"
            + "<if test = 'st !=\"\" and et !=\"\" '>"
            + "and Date BETWEEN #{st} AND #{et}"
            +"</if>"
            + "LIMIT #{limit} OFFSET #{page}"
            +"</script>")
    List<Car> find(CarDto dto);


}
