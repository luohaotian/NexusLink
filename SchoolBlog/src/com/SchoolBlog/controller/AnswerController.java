package com.SchoolBlog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SchoolBlog.model.ArticalBean;
import com.SchoolBlog.model.FinalModel;
import com.SchoolBlog.service.ArticalService;
import com.SchoolBlog.service.LikeService;
import com.SchoolBlog.util.ResultHandler;

@Controller
@RequestMapping("/api/answer")
public class AnswerController {
	@Resource
	private ArticalService articalService;
	@Resource
	private LikeService likeService;
	
	@RequestMapping("/getAnswer")
	@ResponseBody
	public Map<String, Object> getAnswer(
			@RequestParam("answerId") int articalId,
			@RequestParam("userId") int userId){
		ArticalBean artical=this.articalService.getArtical(articalId);
		int code=(artical!=null)?FinalModel.INTERNET_SUCCEED:FinalModel.INTERNET_ERREO;
		Map<String, Object> request=new HashMap<String, Object>();
		if(code==200){
			request.put("isLike", likeService.isLike(articalId, userId));
			request.put("artical", artical);
		}
		return ResultHandler.handleJson("artical", request, code);
	}
	
	@RequestMapping("/refresh")
	@ResponseBody
	public Map<String, Object> refreshArticalList(
			@RequestParam("problemId") int problemId){
		
		return this.articalService.refrashArticalList(problemId);
	}
	
	
	@RequestMapping("/fresh")
	@ResponseBody
	public Map<String, Object> freshArticalList(
			@RequestParam("problemId") int problemId,
			@RequestParam("answerId") int articalId){
		
		return this.articalService.getNextArticalListBytime(articalId,problemId);
	}
	
	@RequestMapping("/publish")
	@ResponseBody
	public Map<String, Object> publishArtical(
			@RequestParam("problemId") int problemId,
			@RequestParam("answerId") int answerId,
			@RequestParam("userId") int userId,
			@RequestParam("content") String content){
		ArticalBean newArtical=new ArticalBean();
		if(content.isEmpty()){
			return ResultHandler.handleJson("info", "NullContent", FinalModel.INTERNET_ERREO);
		}
		newArtical.setId(answerId);
		newArtical.setUserId(userId);
		newArtical.setTitle("ANSWER");
		newArtical.setContent(content);
		newArtical.setStatus(FinalModel.PUBLISH_ARTICAL);
		newArtical.setType(problemId);
		
		return this.articalService.pulishOrSaveArtical(newArtical);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> saveArtical(
			@RequestParam("problemId") int problemId,
			@RequestParam("answerId") int answerId,
			@RequestParam("userId") int userId,
			@RequestParam("content") String content){
		if(content.isEmpty()){
			return ResultHandler.handleJson("info", "NullContent", FinalModel.INTERNET_ERREO);
		}
		ArticalBean artical=new ArticalBean();
		artical.setId(answerId);
		artical.setUserId(userId);
		artical.setTitle("ANSWER");
		artical.setContent(content);
		artical.setType(problemId);
		artical.setStatus(FinalModel.SAVE_ARTICAL);
		if(answerId<=0){
			return this.articalService.pulishOrSaveArtical(artical);
		}
		return this.articalService.reSaveArtical(artical);
		
	}
	
	@RequestMapping("/addContent")
	@ResponseBody
	public Map<String, Object> addContent(
			@RequestParam("answerId") int articalId,
			@RequestParam("addContent") String addString){
		
		return this.articalService.addContent(articalId, addString);
	}
	
}
