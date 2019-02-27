package jit.manage.mapper;

import jit.manage.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Mapper
public interface CarMapper {
    @Select("SELECT * FROM car WHERE CarNumber = #{cn}")
    Car select(@Param("cn")String cn);

    @Insert("INSERT INTO car(CarNumber,CarKind,CarSeat,CarLoad,CarFactory,CarColor,CarState,CarOwner,CarON,Date) VALUES(#{CarNumber},#{CarKind},#{CarSeat},#{CarLoad},#{CarFactory},#{CarColor},#{CarState},#{CarOwner},#{CarON},#{date})")
    boolean add(Car car);

    @Delete("DELECT FROM car WHERE CarNumber = #{cn}")
    Boolean delete(@Param("cn")String cn);

    @Select("SELECT * FROM car limit #{limit} offset #{page}")
    List<Car> selectAll(@Param("page") int page,@Param("limit") int limit);

    @Select("select COUNT(CarNumber) FROM car;")
    int count();
}
