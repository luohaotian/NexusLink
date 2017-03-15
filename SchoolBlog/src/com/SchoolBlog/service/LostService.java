package com.SchoolBlog.service;

import java.util.Map;

import com.SchoolBlog.model.ArticalBean;
import com.SchoolBlog.model.LostBean;

public interface LostService {

	public Map<String , Object> addLost(LostBean lost);
	
	public Map<String , Object> publish(ArticalBean artical);
	
	public Map<String , Object> fresh(int type);
	
	public Map<String , Object> fresh(int type, int lastId);

	public Map<String, Object> solve(int lostId);
}
