package jit.manage.mapper;

import jit.manage.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @Update("UPDATE yonghu set UserId=#{phone},UserName=#{userName} WHERE UserId = #{userId}")
    boolean update(@Param("userId") String userid,@Param("userName") String userName,@Param("phone")String phone);

//    @Select("select * from yonghu where UserName = #{userId}")
//    User select(@Param("userId") String userId);

    @Select("SELECT * from yonghu limit #{limit} offset #{page}")
    List<User> selectAll(@Param("page") int page,@Param("limit") int limit);

    @Select("SELECT count(UserId) from yonghu")
    int countAll();

    @Update("update yonghu set Image = ${path} where UserId=#{id}")
    boolean upload(@Param("path")String path,@Param("id")String id);

    @Update("UPDATE yonghu set UserPW=#{nps} WHERE UserId = #{userId}")
    boolean updateps(@Param("nps")String nps,@Param("userId") String userId);

    @Update("UPDATE yonghu set UserUid=#{uid} WHERE UserId = #{userId}")
    boolean updateuid(@Param("uid")String uid,@Param("userId") String userId);
}
