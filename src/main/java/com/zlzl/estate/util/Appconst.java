package com.zlzl.estate.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 常量类
 */
public class Appconst {

    /**
     * 获取32位uuid
     * @return
     */
    public static String uuid(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;
    }

    /**
     * 上传文件
     * @param request
     * @param file
     * @return
     * @throws IOException
     */
    public static String uploadFile(HttpServletRequest request, MultipartFile file) throws IOException {
        String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
        return mkFile(uploadPath, file);
    }

    public static String mkFile(String filePath, MultipartFile file) throws IOException {
        File dir = new File(filePath);
        if(!dir.exists()){
            dir.mkdir();
        }
        String OriginalFileName = file.getOriginalFilename();
        String fileSuffix = OriginalFileName.substring(OriginalFileName.lastIndexOf("."), OriginalFileName.length() - 1);
        String fileName = uuid() + fileSuffix;
        File newFile = new File(filePath + fileName);
        file.transferTo(newFile);
        return fileName;
    }
}
