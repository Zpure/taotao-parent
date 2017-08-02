package com.taotao.controller;

import com.taotao.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.FileInputStream;

/**
 * Created by zhangchun on 2017/3/28.
 */
public class FTPTest {

    @Test
    public void testFtpClient() throws Exception{
        FTPClient client = new FTPClient();
        client.connect("192.168.49.130", 21);
        client.login("ftpuser", "ftpuser");
        FileInputStream in = new FileInputStream("C:\\Users\\zhangchun\\Pictures\\Camera Roll\\965a0510013f86f4b601b391c9255942.gif");
        client.changeWorkingDirectory("/home/ftpuser/images");
        client.setFileType(FTP.BINARY_FILE_TYPE);
        client.storeFile("hellow1.jpg", in);
        client.logout();

    }

    @Test
    public void testFtpUtil() throws Exception{
        FileInputStream in = new FileInputStream("C:\\Users\\zhangchun\\Pictures\\Camera Roll\\965a0510013f86f4b601b391c9255942.gif");
        FtpUtil.uploadFile("192.168.49.130", 21, "ftpuser", "ftpuser", "/home/ftpuser/images", "/03/29", "hellow.jpg", in);

    }
}
