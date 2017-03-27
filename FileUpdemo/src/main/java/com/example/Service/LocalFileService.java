package com.example.Service;

import com.alibaba.simpleimage.ImageFormat;
import com.alibaba.simpleimage.ImageRender;
import com.alibaba.simpleimage.SimpleImageException;
import com.alibaba.simpleimage.render.*;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by 罗浩 on 2017/3/27.
 */

public class LocalFileService {
    @Resource
    private UploadProperties uploadProperties;

    public String upload(MultipartFile file, String dir, int maxWidth, int maxHeight) {

        String projectFolder = System.getProperty("user.dir");
        String folderAndName = getFileUriGeneratedPart(file, dir);
        String path = projectFolder + uploadProperties.getPath() + folderAndName;

        File realFile = new File(path);
        if (!realFile.getParentFile().mkdirs())
            throw new RuntimeException("创建文件上传目录失败");


    }

    private String getFileUriGeneratedPart(MultipartFile file, String dir) {
        return "/" + dir + "/" + genRandomString(16) +
                "." + getExtensionName(file.getOriginalFilename());
    }

    private void scale(InputStream inputStream, FileOutputStream outputStream, int maxWidth, int maxHeight) throws SimpleImageException {
        ScaleParameter scaleParam = new ScaleParameter(maxWidth, maxHeight);
        WriteParameter writeParam = new WriteParameter();

        ImageRender rr = new ReadRender(inputStream);
        ImageRender sr = new ScaleRender(rr, scaleParam);
        ImageRender wr = null;
        try {
            wr = new WriteRender(sr, outputStream, ImageFormat.JPEG, writeParam);
            wr.render();
        } catch (SimpleImageException e) {
            throw e;
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
            try {
                if (wr != null) {
                    wr.dispose();
                }
            } catch (SimpleImageException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getExtensionName(String filename) {
        if (StringUtils.isNotBlank(filename)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1).toLowerCase();
            }
        }
        return filename;
    }

    private static String genRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
