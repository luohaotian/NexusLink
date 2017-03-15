package com.SchoolBlog.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SchoolBlog.model.ArticalBean;
import com.SchoolBlog.model.FinalModel;
import com.SchoolBlog.service.ProblemService;
import com.SchoolBlog.util.ResultHandler;

@Controller
@RequestMapping("/api/problem")
public class ProblemController {
	@Resource 
	private ProblemService problemService;

	
	@RequestMapping(value="/publish",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> pubishProblem(
			@RequestParam("userId") int userId,
			@RequestParam("title") String title,
			@RequestParam("content") String content){
		if(title.isEmpty()||content.isEmpty())
			return ResultHandler.handleJson("info", "NullTitleOrNullContent", FinalModel.INTERNET_ERREO);
		ArticalBean problem=new ArticalBean();
		problem.setId(0);
		problem.setUserId(userId);
		problem.setTitle(title);
		problem.setContent(content.trim());
		problem.setType(FinalModel.PROBLEM_TYPE);
		problem.setStatus(FinalModel.PUBLISH_ARTICAL);
		return this.problemService.pulishOrSaveProblem(problem);
	}
		
	@RequestMapping("/refresh")
	@ResponseBody
	public Map<String, Object> fresh(){
			
		return this.problemService.refreshProblemList();	
	}
		
	@RequestMapping(value="/fresh")
	@ResponseBody
	public Map<String, Object> refreshArticalList(
			@RequestParam("problemId") int problemId){
			
		return this.problemService.getNextProblemList(problemId);
	}
}
	
