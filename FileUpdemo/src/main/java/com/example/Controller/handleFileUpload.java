package com.example.Controller;

import com.alibaba.simpleimage.ImageFormat;
import com.alibaba.simpleimage.ImageRender;
import com.alibaba.simpleimage.SimpleImageException;
import com.alibaba.simpleimage.render.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 罗浩 on 2017/3/27.
 */

@Controller
@RequestMapping(value = "/fileupload")
public class handleFileUpload {
    @RequestMapping(value = "/up",method = RequestMethod.POST)
    public List<String> fileup(@RequestParam("files") MultipartFile[] files, HttpServletRequest request){

        //获取当前项目路径
        String projectFolder = System.getProperty("user.dir");
        //String path = request.getContextPath();

        List<String> publicPathList = new ArrayList<String>();

        for (MultipartFile file : files) {

            String publicPath = "/resource/image" + file.getOriginalFilename();
            File imageFile = new File(projectFolder + publicPath);

            try {
                file.transferTo(imageFile);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.print("添加图片失败");
            }

            publicPathList.add(publicPath);
        }

        return publicPathList;
    }

    //对图片进行压缩处理，使用阿里的图片处理库：SimpleImage
    private void scale(InputStream inputStream, FileOutputStream outputStream){
        //这里默认最大宽度1024，最大高度1024了，可根据需求做成参数
        ScaleParameter scaleParam = new ScaleParameter(1024,1024);
        WriteParameter writeParam = new WriteParameter();

        ImageRender rr = new ReadRender(inputStream);
        ImageRender sr = new ScaleRender(rr, scaleParam);
        ImageRender wr = null;
        try {
            wr = new WriteRender(sr, outputStream, ImageFormat.JPEG, writeParam);
            wr.render();
        } catch (SimpleImageException e) {
            e.printStackTrace();
            throw new RuntimeException("压缩文件失败");
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
            try {
                if (wr != null) {
                    wr.dispose();
                }
            } catch (SimpleImageException e) {
                // ignore ...
                e.printStackTrace();
                throw new RuntimeException("压缩文件失败");
            }
        }


    }
}

