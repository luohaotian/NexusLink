package com.SchoolBlog.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.SchoolBlog.dao.LostDao;
import com.SchoolBlog.dao.UserDao;
import com.SchoolBlog.model.LostBean;

public class LostDaoImpl implements LostDao {
	@Resource
	private UserDao userDao;
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	final int limit=com.SchoolBlog.model.FinalModel.ARTICAL_LIMIT;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public boolean addLost(LostBean lost) {
		try{
		      String sql="INSERT INTO tb_lost("
		      		+ "lost_xuehao,lost_getterId,lost_place,"
		      		+ "lost_phone,lost_info,lost_getTime) "
				+ " VALUES(?,?,?,?,?,NOW())";
		      Object[] params=new Object[]{
		    		  lost.getLostXuehao(),
		    		  lost.getGetterId(),
		    		  lost.getLostPlace(),
		    		  lost.getLostPhone(),
		    		  lost.getLostInfo()};
		      this.jdbcTemplate.update(sql,params);
		      return true;
		      
		}catch(Exception e){
			e.printStackTrace();
			e.getMessage();
			return false;
		}
	}

	@Override
	public List<LostBean> getLostList(int userId) {
		String sql="select user_xuehao from tb_user where user_id=?";
		String xuehao=this.jdbcTemplate.queryForObject(sql, new Object[]{userId}, String.class);
		
		sql="select * from tb_lost where lost_xuehao=? and lost_status=0";
		List<LostBean> losts = new ArrayList<LostBean>();
		this.jdbcTemplate.query(sql, new Object[]{xuehao}, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
					LostBean lost=new LostBean();
					lost.setId(rs.getInt("lost_id"));
					lost.setLostXuehao(rs.getString("lost_xuehao"));
					lost.setLostPlace(rs.getString("lost_place"));
					lost.setLostPhone(rs.getString("lost_phone"));
					lost.setLostInfo(rs.getString("lost_info"));
					lost.setStatus(rs.getInt("lost_status"));
					lost.setGetTime(rs.getDate("lost_getTime"));
					lost.setGetter(userDao.getAllInfo(rs.getInt("lost_getterId")));
					losts.add(lost);
					
			}
		});
		return losts;
		
	}

	@Override
	public boolean solve(int lostId) {
		try{
		String sql="update tb_lost set lost_status=1 where lost_id=?";
		
		 this.jdbcTemplate.update(sql, new Object[]{lostId});
		 return true;
		}catch(Exception e){
			return false;
		}
		
	}

}
