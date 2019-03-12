package jit.manage.mapper;

import jit.manage.Dto.CarDto;
import jit.manage.Dto.TongjiDto;
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
            + "<if test = 'carNumber !=\"\" and carNumber !=null'>"
            + "and CarNumber = #{carNumber}"
            +"</if>"
            + "<if test = 'carKind !=\"\" and carKind !=null'>"
            + "and CarKind = #{carKind}"
            +"</if>"
            + "<if test = 'st !=\"\" and et !=\"\" and st != null and et !=null'>"
            + "and Date BETWEEN #{st} AND #{et}"
            +"</if>"
            +"</script>")
    int count2(CarDto dto);

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

    @Update("UPDATE car set CarState = #{CarState} where CarNumber = #{CarNumber}")
    boolean updateState(@Param("CarState") String CarState,@Param("CarNumber") String CarNumber);

    //近30天
    @Select("SELECT COUNT(CarNumber) FROM car where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <=date(Date) ")
    List<Car> month30();

    //近七天
    @Select("SELECT COUNT(CarNumber) FROM car where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <=date(Date) ")
    List<Car> week();

    //这个月
    @Select("SELECT COUNT(CarNumber) FROM car WHERE DATE_FORMAT( Date, '%Y%m' ) =DATE_FORMAT( CURDATE( ) , '%Y%m' ) ")
    List<Car> month();

    //前n个月
    @Select("SELECT COUNT(CarNumber) FROM car WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( Date, '%Y%m' ) ) = #{n} ")
    List<Car> month1(@Param("n") String n);

    //今年
    @Select("select COUNT(CarNumber) from car where YEAR(Date)=YEAR(NOW())  ")
    List<Car> year();

    //第前n年各种车型的统计
    @Select("select CarKind kind,count(CarKind) count from car where year(Date)=year(date_sub(now(),interval #{n} year)) GROUP BY CarKind")
    List<TongjiDto> yeark(int n);

    //今年各种车型的统计
    @Select("select CarKind kind,count(CarKind) count from car where YEAR(Date)=YEAR(NOW()) GROUP BY CarKind")
    List<TongjiDto> yeark2();


    //今年各种车状态的统计
    @Select("select CarState kind,count(CarState) count from car where YEAR(Date)=YEAR(NOW()) GROUP BY CarState")
    List<TongjiDto> years2();

    //第前n年各种车状态的统计
    @Select("select CarState kind,count(CarState) count from car where year(Date)=year(date_sub(now(),interval #{n} year)) GROUP BY CarState")
    List<TongjiDto> years(int n);

    //近一年字段统计
    @Select("select ${name} kind,count(${name}) count from car where YEAR(Date)=YEAR(NOW()) GROUP BY ${name}")
    List<TongjiDto> yearKind(@Param("name") String name);

}
