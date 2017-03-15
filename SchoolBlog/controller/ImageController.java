package com.SchoolBlog.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.SchoolBlog.model.FinalModel;
import com.SchoolBlog.service.ImageService;
import com.SchoolBlog.util.ResultHandler;

@Controller
@RequestMapping(value="/api/image")
public class ImageController {
	
	@Autowired
    private ImageService imageService;
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
    @ResponseBody
	public Map<String,Object> uploadImg(@RequestParam("userId")int userId,
			@RequestParam("file")MultipartFile file,HttpServletRequest request){
		
				String fileName = file.getOriginalFilename();
				//判断所传文件是否为图片类型
				String postFix = fileName.substring(fileName.lastIndexOf(".")+1);
				if(postFix.equalsIgnoreCase("bmp") || postFix.equalsIgnoreCase("jpg")|| postFix.equalsIgnoreCase("png")||postFix.equalsIgnoreCase("jpeg")){
					fileName = request.getRemoteHost()+System.currentTimeMillis() +"."+postFix;
					return this.imageService.upload(request,file,fileName,userId);
				}else{
					return ResultHandler.handleJson("uploadImg", "notImg", FinalModel.INTERNET_ERREO);
				}
			}
}
