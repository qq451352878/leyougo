package com.leyou.service.impl;

import com.leyou.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Service
public class uploadServiceImpl implements UploadService {

    private static final Logger logger= LoggerFactory.getLogger(uploadServiceImpl.class);
    private static final List<String> AllOW_TYPES= Arrays.asList ("image/jpeg","image/png","image/bmp");
    @Override
    public String uploadImage(MultipartFile file) {

        try {
            //判断文件类型
            String contentType = file.getContentType ( );
            if (!AllOW_TYPES.contains (contentType)){
                return null;
            }


            //保存文件到本例
            //准备路径
            File dest = new File ("D:/ideaProject/spring_cloud/upload", file.getOriginalFilename ( ));
            file.transferTo (dest);
            //返回路径

            return "http://image.leyou.com/" + file.getOriginalFilename ( );
        } catch (IOException e) {
            return null;
        }

    }
}
