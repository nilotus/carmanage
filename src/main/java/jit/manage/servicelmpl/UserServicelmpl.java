package jit.manage.servicelmpl;

import jit.manage.mapper.UserMapper;
import jit.manage.pojo.User;
import jit.manage.service.UserService;
import jit.manage.util.FtpClientUtil;
import jit.manage.util.MSG;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sunlotus on 2019/2/21.
 */
@Service
public class UserServicelmpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public MSG addUser(User user) {
        user.setImage("\"http://120.78.168.194/images/cs1.jpg\"");
        System.out.println(user.toString());
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

    @Override
    public String users(int page,int limit){
        page = (page-1)*limit;
        int count = userMapper.countAll();
        MSG msg = new MSG(0,"",count,userMapper.selectAll(page,limit));
        JSONObject object = JSONObject.fromObject(msg);
        return object.toString();
    }

    @Override
    public MSG upload(String id,MultipartFile image) throws IOException {
        if (null !=image){
            String path = "C:\\JDKPro2\\images\\";
            String name = id + ".jpg";
            String imagepath="http://120.78.168.194/images/"+name;
            String localfilename=path+name;
            File file = new File(localfilename);
            image.transferTo(file);
            String remotefilename= "pro/images/"+name;
            FtpClientUtil clientUtil =new FtpClientUtil();
            clientUtil.upload(remotefilename,localfilename);
            String path2 = "'"+"\""+imagepath+"\""+"'";
            userMapper.upload(path2,id);
            return new MSG(1,"上传成功");
        }
        return new MSG(0,"上传文件为空");
    }
}