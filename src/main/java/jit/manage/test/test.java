package jit.manage.test;

import jit.manage.util.FtpClientUtil;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by sunlotus on 2019/3/20.
 */
public class test {
    public static void main(String[] args) throws IOException {
        String remotefilename= "pro/images/cat.jpg";
        String localfilename="C:\\JDKPro\\pictures\\cat2.jpg";
        FtpClientUtil clientUtil =new FtpClientUtil();
        clientUtil.upload(remotefilename,localfilename);



    }


}
