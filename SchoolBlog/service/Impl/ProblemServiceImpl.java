package com.SchoolBlog.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.SchoolBlog.dao.ArticalDao;
import com.SchoolBlog.model.ArticalBean;
import com.SchoolBlog.model.FinalModel;
import com.SchoolBlog.service.ProblemService;
import com.SchoolBlog.util.ResultHandler;

public class ProblemServiceImpl implements ProblemService {
	@Resource
	private ArticalDao articalDao;
	@Override
	public ArticalBean getPrblem(int problemId) {
		this.articalDao.addLookNum(problemId);
		return this.articalDao.getArtical(problemId);
	}

	@Override
	public Map<String, Object> pulishOrSaveProblem(ArticalBean problem) {
		// TODO Auto-generated method stub
		if(problem.getId()>0){
			this.articalDao.delArtical(problem.getId());
		}
		int code=articalDao.addArtical(problem)?FinalModel.INTERNET_SUCCEED:FinalModel.INTERNET_ERREO;
		return ResultHandler.handleJson("publishOrsave", null, code);
	}
	
	@Override
	public Map<String, Object> resaveProblem(ArticalBean problem) {
		// TODO Auto-generated method stub
		int code=articalDao.reSaveArtical(problem)?FinalModel.INTERNET_SUCCEED:FinalModel.INTERNET_ERREO;
		return ResultHandler.handleJson("resave", null, code);
	}

	@Override
	public Map<String, Object> refreshProblemList() {
		// TODO Auto-generated method stub
		List<ArticalBean> list=this.articalDao.getArticals(FinalModel.PROBLEM_TYPE);
		int code=(list.isEmpty())?FinalModel.INTERNET_ERREO:FinalModel.INTERNET_SUCCEED;

		return ResultHandler.handleJson("articals", list, code);
	}

	@Override
	public Map<String, Object> getNextProblemList(int problemId) {
		// TODO Auto-generated method stub
		List<ArticalBean> list=articalDao.freshArticals(problemId,FinalModel.PROBLEM_TYPE);
		int code=list.isEmpty()?FinalModel.INTERNET_ERREO:FinalModel.INTERNET_SUCCEED;
		return ResultHandler.handleJson("articals", list, code);
	}

	

}
