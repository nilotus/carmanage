package jit.manage.test;

import jit.manage.mapper.MapMapper;
import jit.manage.util.FtpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;


/**
 * Created by sunlotus on 2019/3/20.
 */
public class test {
    @Autowired
    private MapMapper mapMapper;

    public static void main(String[] args) {
        String place = "江苏省南京市鼓楼区";
        String city = place.substring(0,place.indexOf("市")+1);
        System.out.println(city);
    }


}
