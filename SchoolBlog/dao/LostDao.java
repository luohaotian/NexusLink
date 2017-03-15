package com.SchoolBlog.dao;

import java.util.List;
import com.SchoolBlog.model.LostBean;

public interface LostDao {

	public boolean addLost (LostBean lost);

	List<LostBean> getLostList(int userId);

	public boolean solve(int lostId);
}
