package jit.manage.mapper;

import jit.manage.pojo.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by sunlotus on 2019/2/21.
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO yonghu(UserId,UserName,UserPW,UserUid,Image) VALUES(#{userId},#{userName},#{userPW},#{userUid},#{image})")
    boolean addUser(User user);

    @Select("select UserPW from yonghu where UserId = #{userName}")
    String login(@Param("userName") String userName);

    @Select("select UserUid from yonghu where UserId = #{userName}")
    int identify(@Param("userName") String userName);

    @Select("SELECT * FROM yonghu WHERE UserId = #{userId}")
    User findbyid(@Param("userId") String userId);

    @Delete("DELETE FROM yonghu WHERE UserId = #{userId}")
    boolean delete(@Param("userId") String userId);

    @Update("UPDATE yongu set UserId=#{userId},UserName=#{userName},UserPW=#{userPW},UserUid=#{userUid} WHERE UserId = #{userId}")
    boolean update(User user);

    @Select("select * from yonghu where UserName = #{userId}")
    User select(@Param("userId") String userId);
}
