package com.SchoolBlog.service.Impl;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.SchoolBlog.dao.UserDao;
import com.SchoolBlog.model.FinalModel;
import com.SchoolBlog.service.CommentService;
import com.SchoolBlog.service.ImageService;
import com.SchoolBlog.util.ResultHandler;

public class ImageServiceImpl implements ImageService  {
	
	@Resource
	private UserDao userDao;
	
	public Map<String,Object> upload(HttpServletRequest request,MultipartFile file,String fileName,int userId){
		
		ServletContext context = request.getServletContext();
		String path  =  context.getRealPath("/")+"image/";
		String urlName = context.getInitParameter("webIp")+request.getServerPort()+context.getContextPath()+"/image/"+fileName;
		boolean flag = this.userDao.uploadHeadImg(userId,urlName);
		int code = 0;
		
		if(flag){

			try {
				File fl = new File(path,fileName);
				file.transferTo(fl);
			    code = FinalModel.INTERNET_SUCCEED;
			    
			} catch (IllegalStateException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			   code = FinalModel.INTERNET_ERREO;
			} catch (IOException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			   code = FinalModel.INTERNET_ERREO;
			}	
		}else
			code = FinalModel.INTERNET_ERREO;
		
		return ResultHandler.handleJson("uploadHeadImg",null,code); 
		
	}

}
