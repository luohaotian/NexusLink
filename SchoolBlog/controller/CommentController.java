package com.SchoolBlog.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SchoolBlog.model.CommentBean;
import com.SchoolBlog.model.FinalModel;
import com.SchoolBlog.service.CommentService;
import com.SchoolBlog.util.ResultHandler;

@Controller
@RequestMapping("/api/comment")
public class CommentController {

	@Resource
	private CommentService commentService;
	
	
	@RequestMapping("/publishComment")
	@ResponseBody
	public Map<String, Object> publishComment(
			@RequestParam("userId") int userId,
			@RequestParam("articalId") int articalId,
			@RequestParam("content") String content,
			@RequestParam("replyFloor") int replyFloor){
		if(content.isEmpty()){
			return ResultHandler.handleJson("info", "�������ݲ���Ϊ��", FinalModel.INTERNET_ERREO);
		}
		CommentBean comment=new CommentBean();
		comment.setArticalId(articalId);
		comment.setUserId(userId);
		comment.setContent(content);
		comment.setReplyFloor(replyFloor);
		
		return this.commentService.publishComment(comment);
	}
	
	@RequestMapping("/getComments")
	@ResponseBody
	public Map<String, Object> getComments(
			@RequestParam("articalId") int articalId,
			@RequestParam("lastFloor") int lastFloor){
		
		return this.commentService.getComments(articalId, lastFloor);
	}
}
