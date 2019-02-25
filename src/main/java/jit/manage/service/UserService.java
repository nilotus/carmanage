package jit.manage.service;

import jit.manage.pojo.User;
import jit.manage.util.MSG;

/**
 * Created by sunlotus on 2019/2/21.
 */
public interface UserService {
    MSG addUser(User user);

    MSG login(String userName,String userPW);

    MSG findOne(String userId);
}
