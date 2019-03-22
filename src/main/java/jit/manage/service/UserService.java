package jit.manage.service;

import jit.manage.pojo.User;
import jit.manage.util.MSG;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by sunlotus on 2019/2/21.
 */
public interface UserService {
    MSG addUser(User user);

    MSG login(String userName,String userPW);

    MSG findOne(String userId);

    MSG delete(String userId);

    MSG userInfo(String userId);

    String users(int page,int limit);

    MSG upload(String id,MultipartFile image) throws IOException;
}
