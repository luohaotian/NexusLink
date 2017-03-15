package com.SchoolBlog.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.SchoolBlog.dao.UserDao;
import com.SchoolBlog.model.UserBean;

public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Integer adduser(UserBean user) {
		try{
		      String sql="INSERT INTO tb_user(user_xuehao,user_password,user_realname,user_sex,user_info,user_grade) "
				+ " VALUES(?,?,?,?,?,?)";
		      Object[] params=new Object[]{user.getXuehao(),user.getPassword(),user.getRealname(),user.getSex(),user.getInfo(),user.getGrade()};
		      this.jdbcTemplate.update(sql,params);
		      String resultSql="SELECT user_id FROM tb_user WHERE user_xuehao=?";//SELECT last_insert_id();
		      return (int)this.jdbcTemplate.queryForObject(resultSql,
		    		  new Object[]{Integer.parseInt(user.getXuehao())},Integer.class);
		      
		}catch(Exception e){
			e.printStackTrace();
			e.getMessage();
			return -1;
		}
	}
	
	@Override
	public String ensureAccount(String xuehao){
		String password=null;
		String sql="SELECT user_password FROM tb_user WHERE user_xuehao=?";
		password=this.jdbcTemplate.queryForObject(sql, new Object[]{xuehao}, String.class);
		return password;
		
	}

	@Override
	public Integer alertUserInfo(UserBean user) {
		// �޸��û���Ϣ���ɹ������û�id��ʧ�ܷ���-1
		try{
			String sql="UPDATE tb_user SET user_info=? WHERE user_id=?";
		    this.jdbcTemplate.update(sql, new Object[]{user.getInfo(),user.getId()});
		    return (Integer)user.getId();
		}catch(Exception e){
			e.getMessage();
			new RuntimeException("�޸��û�ʧ��!");
			return -1;
		}
	}

	@Override
	public 	Integer addUserLike(int userId,int num) {
		// TODO Auto-generated method stub
		try{
			String sql="UPDATE tb_user SET user_like+"+num+" WHERE user_id=" + userId;
			return this.jdbcTemplate.update(sql);
		}catch(Exception e){
			e.getMessage();
			return -1;
		}
		
	}

	@Override
	public Integer addUserScore(int userId,int score){
		try{
			String sql="UPDAT tb_user SET user_score = user_score + ? WHERE user_id= ?";
			return this.jdbcTemplate.update(sql,new Object[]{score,userId});
		}catch(Exception e){
			e.getMessage();
			return -1;
		}
		
	}

	@Override
	public String getRealnameById(int userId) {
		// TODO Auto-generated method stub
		String sql="SELECT user_realname FROM tb_user WHEREw user_id=?";
		return this.jdbcTemplate.queryForObject(
				sql,new Object[]{userId}, String.class);
	}

	@Override
	public UserBean getAllInfo(int userId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tb_user WHERE user_id = ?";
		UserBean user=new UserBean();
		user.setId(userId);
		this.jdbcTemplate.query(sql, new Object[]{userId}, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				user.setXuehao(rs.getString("user_xuehao"));
				user.setRealname(rs.getString("user_realname"));
				user.setSex(rs.getString("user_sex"));
				user.setInfo(rs.getString("user_info"));
				user.setLike(rs.getInt("user_like"));
				user.setScore(rs.getInt("user_score"));
				user.setGrade(rs.getString("user_grade"));
			}
		});
		return user;
	}

	@Override
	public int getUserId(String xuehao) {
		try{
			String sql="SELECT user_id FROM tb_user WHERE user_xuehao=?";
			return this.jdbcTemplate.queryForObject(sql, new Object[]{xuehao}, Integer.class);
		}catch(Exception e){
			e.getMessage();
			return 0;
		}
	}

	@Override
	public boolean uploadHeadImg(int userId, String urlName) {
		// TODO Auto-generated method stub
		try{
			String sql = "UPDATE tb_user SET user_img=? WHERE user_id = ?";
			this.jdbcTemplate.update(sql, new Object[]{urlName,userId});
			return true;
		}catch(Exception e){
			e.getMessage();
			return false;
		}
		
	}
}
