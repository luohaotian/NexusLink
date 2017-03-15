package com.SchoolBlog.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.SchoolBlog.dao.ArticalDao;
import com.SchoolBlog.dao.LostDao;
import com.SchoolBlog.model.ArticalBean;
import com.SchoolBlog.model.FinalModel;
import com.SchoolBlog.model.LostBean;
import com.SchoolBlog.service.LostService;
import com.SchoolBlog.util.ResultHandler;

public class LostServiceImpl implements LostService {

	@Resource
	private LostDao lostDao;
	@Resource
	private ArticalDao	articalDao;
	
	
	@Override
	public Map<String, Object> addLost(LostBean lost) {
		int code=this.lostDao.addLost(lost)?
				FinalModel.INTERNET_SUCCEED:FinalModel.INTERNET_ERREO;
		return ResultHandler.handleJson("lost", null, code);
	}


	@Override
	public Map<String, Object> publish(ArticalBean artical) {
		
		if(artical.getContent().isEmpty()||artical.getTitle().isEmpty()){
			return ResultHandler.handleJson("info", "NullTitleOrNullContent",FinalModel.INTERNET_ERREO);
		}
		
		int code=articalDao.addArtical(artical)?FinalModel.INTERNET_SUCCEED:FinalModel.INTERNET_ERREO;
		return ResultHandler.handleJson("Artical", null, code);
	}


	@Override
	public Map<String, Object> fresh(int type) {
		List<ArticalBean> articals=this.articalDao.getArticals(type);
		int code = articals.isEmpty()?
				FinalModel.INTERNET_ERREO:FinalModel.INTERNET_SUCCEED;
		return ResultHandler.handleJson("aticals", articals, code);
	}


	@Override
	public Map<String, Object> fresh(int type, int lastId) {
		List<ArticalBean> articals=this.articalDao.freshArticals(lastId, type);
		int code = articals.isEmpty()?
				FinalModel.INTERNET_ERREO:FinalModel.INTERNET_SUCCEED;
		return ResultHandler.handleJson("aticals", articals, code);
	}


	@Override
	public Map<String, Object> solve(int lostId) {
		int code= this.lostDao.solve(lostId)?
				FinalModel.INTERNET_SUCCEED:FinalModel.INTERNET_ERREO;
		
		return ResultHandler.handleJson("solve", null, code);
	}

}
