package com.SchoolBlog.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.SchoolBlog.model.ArticalBean;

public interface AnswerService {

	public ArticalBean getArtical(int articalId);
	
	public Map<String, Object>pulishOrSaveAnswer(ArticalBean artical);
	
	public Map<String, Object>reSaveAnswer(ArticalBean artical);
	
	public Map<String, Object> refrashAnswerList(int type);
	
	public Map<String, Object> getMyAnswer(int userId,int isPublish);
	
	public Map<String, Object> getNextArticalListBytime(int articalId,int type);
	
	public Map<String, List<ArticalBean>>getArticalListByLike(int page,Date time);
	
	public Map<String, List<ArticalBean>>getArticalListByLook(int page,Date time);
	
	public Map<String, List<ArticalBean>>searchArticalList(int page,String keyWord,Date time);
	
	public Map<String, Object>deleteArtical(int articleId);
	
	public Map<String, Object>addContent(int articalId,String addString);
	
	
	
	
}