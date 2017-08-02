package com.taotao.service;

import com.taotao.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zhangchun on 2017/3/29.
 */
public interface PictureService {
    PictureResult uploadPicture(MultipartFile uploadFile);
}
