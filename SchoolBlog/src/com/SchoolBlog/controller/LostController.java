package com.SchoolBlog.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SchoolBlog.model.ArticalBean;
import com.SchoolBlog.model.FinalModel;
import com.SchoolBlog.model.LostBean;
import com.SchoolBlog.service.LostService;
import com.SchoolBlog.util.ResultHandler;

@Controller
@RequestMapping("/api/lose")
public class LostController {

	@Resource
	private LostService lostService;
	
	@RequestMapping("/E-Card")
	@ResponseBody
	public Map<String, Object> pickupEcard(
			@RequestParam("userId") int userId,
			@RequestParam("xuehao") String xuehao,
			@RequestParam("place") String place,
			@RequestParam("phone") String phone,
			@RequestParam("info") String info
			){
		LostBean lost=new LostBean();
		lost.setGetterId(userId);
		lost.setLostXuehao(xuehao);
		lost.setLostPlace(place);
		lost.setLostPhone(phone);
		lost.setLostInfo(info);
		
		return this.lostService.addLost(lost);
	}
	
	@RequestMapping("/pickup")
	@ResponseBody
	public Map<String , Object> pickup (
		@RequestParam("userId") int userId,
		@RequestParam("title") String title,
		@RequestParam("content") String content){
		ArticalBean newArtical=new ArticalBean();
		if(title.isEmpty()||content.isEmpty()){
			return ResultHandler.handleJson("info", "NullTitleOrNullContent", FinalModel.INTERNET_ERREO);
		}
		newArtical.setId(0);
		newArtical.setUserId(userId);
		newArtical.setTitle(title);
		newArtical.setContent(content);
		newArtical.setStatus(FinalModel.PUBLISH_ARTICAL);
		newArtical.setType(FinalModel.PICKUP_TYPE);
		
		return this.lostService.publish(newArtical);
	}
	
	@RequestMapping("/lose")
	@ResponseBody
	public Map<String , Object> lose (
		@RequestParam("userId") int userId,
		@RequestParam("title") String title,
		@RequestParam("content") String content){
		ArticalBean newArtical=new ArticalBean();
		if(title.isEmpty()||content.isEmpty()){
			return ResultHandler.handleJson("info", "NullTitleOrNullContent", FinalModel.INTERNET_ERREO);
		}
		newArtical.setId(0);
		newArtical.setUserId(userId);
		newArtical.setTitle(title);
		newArtical.setContent(content);
		newArtical.setStatus(FinalModel.PUBLISH_ARTICAL);
		newArtical.setType(FinalModel.LOSE_TYPE);
		
		return this.lostService.publish(newArtical);
	}
	
	@RequestMapping("/refreshLoseList")
	@ResponseBody
	public Map<String, Object> getLoseList(){
		return this.lostService.fresh(FinalModel.LOSE_TYPE);
	}
	
	@RequestMapping("/refreshPickupList")
	@ResponseBody
	public Map<String, Object> refreshPickupList(){
		return this.lostService.fresh(FinalModel.PICKUP_TYPE);
	}
	
	@RequestMapping("/getMorePickupList")
	@ResponseBody
	public Map<String, Object> getMorePickupList(
			@RequestParam("articalId") int articalId){
		return this.lostService.fresh(FinalModel.PICKUP_TYPE,articalId);
	}
	
	@RequestMapping("/getMoreLoseList")
	@ResponseBody
	public Map<String, Object> getMoreLoseList(
			@RequestParam("articalId") int articalId){
		return this.lostService.fresh(FinalModel.LOSE_TYPE,articalId);
	}
	
	@RequestMapping("/solve")
	@ResponseBody
	public Map<String, Object> solve(
			@RequestParam("loseId")int lostId){
		
		return this.lostService.solve(lostId);
		
	}
}
