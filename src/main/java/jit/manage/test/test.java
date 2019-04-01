package jit.manage.test;

import jit.manage.mapper.MapMapper;
import jit.manage.util.FtpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Arrays;


/**
 * Created by sunlotus on 2019/3/20.
 */
public class test {
    @Autowired
    private MapMapper mapMapper;

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.of(2019,4,1,9,0);
        LocalDateTime localDateTime1 = LocalDateTime.of(2019,5,1,9,20,8);
        if (localDateTime.isBefore(localDateTime1))
            System.out.println("yes");
    }


}
