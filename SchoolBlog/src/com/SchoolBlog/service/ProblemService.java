package com.SchoolBlog.service;

import java.util.Map;

import com.SchoolBlog.model.ArticalBean;

public interface ProblemService {
	public ArticalBean getPrblem(int problrmId);
	
	public Map<String, Object>pulishOrSaveProblem(ArticalBean artical);
	
	public Map<String, Object> refreshProblemList();
	
	public Map<String, Object> getNextProblemList(int problemId);

	public Map<String, Object> resaveProblem(ArticalBean problem);
	
}
