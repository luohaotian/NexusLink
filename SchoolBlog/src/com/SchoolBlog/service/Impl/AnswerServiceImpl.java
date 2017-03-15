package com.SchoolBlog.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.SchoolBlog.dao.ArticalDao;
import com.SchoolBlog.model.ArticalBean;
import com.SchoolBlog.service.AnswerService;

public class AnswerServiceImpl implements AnswerService {

	@Resource
	private ArticalDao articalDao;
	


	@Override
	public ArticalBean getArtical(int articalId) {
		
		return null;
	}

	@Override
	public Map<String, Object> pulishOrSaveAnswer(ArticalBean artical) {
		
		return null;
	}

	@Override
	public Map<String, Object> reSaveAnswer(ArticalBean artical) {
		
		return null;
	}

	@Override
	public Map<String, Object> refrashAnswerList(int type) {
		
		return null;
	}

	@Override
	public Map<String, Object> getMyAnswer(int userId, int isPublish) {
		
		return null;
	}

	@Override
	public Map<String, Object> getNextArticalListBytime(int articalId,
			int type) {
		
		return null;
	}

	@Override
	public Map<String, List<ArticalBean>> getArticalListByLike(int page,
			Date time) {
		
		return null;
	}

	@Override
	public Map<String, List<ArticalBean>> getArticalListByLook(int page,
			Date time) {
		
		return null;
	}

	@Override
	public Map<String, List<ArticalBean>> searchArticalList(int page,
			String keyWord, Date time) {
		
		return null;
	}

	@Override
	public Map<String, Object> deleteArtical(int articleId) {
		
		return null;
	}

	@Override
	public Map<String, Object> addContent(int articalId, String addString) {
		
		return null;
	}

	

}
