package jit.manage.mapper;

import jit.manage.pojo.Car;
import org.apache.ibatis.annotations.*;

/**
 * Created by sunlotus on 2019/2/25.
 */
@Mapper
public interface CarMapper {
    @Select("SELECT * FROM car WHERE CarNumber = #{cn}")
    Car select(@Param("cn")String cn);

    @Insert("INSERT INTO car(CarNumber,CarKind,CarSeat,CarLoad,CarFactory,CarColor,CarState,CarOwner,CarON,Date) VALUES(#{CarNumber},#{CarKind}，#{CarSeat},#{CarLoad},#{CarFactory},#{CarColor},#{CarState},#{CarOwner},#{CarON},#{date})")
    boolean add(Car car);

    @Delete("DELECT FROM car WHERE CarNumber = #{cn}")
    Boolean delete(@Param("cn")String cn);

}
