package com.SchoolBlog.dao;

import java.util.List;

public interface LikeDao {

	public boolean addLike( int articalId, int userId);
	
	public boolean delLike( int articalId, int userId);
	
	public boolean isLike (int articalId, int userId);
	
	public List<Integer> mylike(int userId ,int page);
}
