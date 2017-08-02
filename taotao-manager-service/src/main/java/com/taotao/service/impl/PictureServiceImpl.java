package com.taotao.service.impl;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zhangchun on 2017/3/29.
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USER_NAME}")
    private String FTP_USER_NAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Override
    public PictureResult uploadPicture(MultipartFile uploadFile){
        //获取上传文件的文件名
        String originalFilename = uploadFile.getOriginalFilename();
        //获取原始文件扩展名
        String etx = originalFilename.substring(originalFilename.indexOf("."));
        String newName = IDUtils.genImageName() + etx;
        String filePath = new DateTime().toString("/yyyy/MM/dd");
        try {
            FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, FTP_BASE_PATH, filePath, newName, uploadFile.getInputStream());

        } catch (Exception e){
            e.printStackTrace();
            return PictureResult.error("文件上传失败");
        }
        return PictureResult.ok(IMAGE_BASE_URL + filePath + "/" + newName);

    }
}
