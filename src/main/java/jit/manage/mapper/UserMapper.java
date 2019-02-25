package jit.manage.mapper;

import jit.manage.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by sunlotus on 2019/2/21.
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO yonghu(UserId,UserName,UserPW,UserUid) VALUES(#{userId},#{userName},#{userPW},#{userUid})")
    boolean addUser(User user);

    @Select("select UserPW from yonghu where UserName = #{userName}")
    String login(@Param("userName") String userName);

    @Select("select UserUid from yonghu where UserName = #{userName}")
    int identify(@Param("userName") String userName);

    @Select("SELECT * FROM yonghu WHERE UserId = #{userId}")
    User findbyid(@Param("userId") String userId);
}
