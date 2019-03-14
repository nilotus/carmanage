package jit.manage.servicelmpl;

import jit.manage.mapper.UserMapper;
import jit.manage.pojo.User;
import jit.manage.service.UserService;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunlotus on 2019/2/21.
 */
@Service
public class UserServicelmpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public MSG addUser(User user) {
        user.setImage("http://120.78.168.194/images/cs1.jpg");
        if (userMapper.addUser(user))
            return new MSG(1, "增加用户成功");
        else
            return new MSG(-1, "增加用户失败");
    }

    @Override
    public MSG login(String userId, String userPW) {
        String pw = userMapper.login(userId);
        //System.out.println(userMapper.identify(userId));
        if (pw.equals(userPW)) {
            return new MSG(1, "登录成功",userMapper.identify(userId));
        } else
            return new MSG(-1, "用户名或密码错误");
    }

    @Override
    public MSG findOne(String userId) {
        User user = userMapper.findbyid(userId);
        if (user != null)
            return new MSG(-1, "用户已存在");
        else
            return new MSG(1, "用户可用");
    }

    @Override
    public MSG delete(String userId){
        if (userMapper.delete(userId)){
            return new MSG(1, "已注销");
        }else
            return new MSG(-1, "注销失败");
    }

    @Override
    public MSG userInfo(String userId){
        return new MSG(1, "sucess",userMapper.findbyid(userId));
    }
}