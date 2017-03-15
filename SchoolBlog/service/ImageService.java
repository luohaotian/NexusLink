package com.SchoolBlog.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	Map<String,Object> upload(HttpServletRequest request, MultipartFile file, String fileName, int userId);

}
