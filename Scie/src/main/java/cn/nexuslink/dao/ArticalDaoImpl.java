package cn.nexuslink.dao;

import cn.nexuslink.dao.mapper.articalMapper;
import cn.nexuslink.model.ArticalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by 罗浩 on 2017/3/18.
 */

@Repository("articalDao")
public class ArticalDaoImpl implements ArticalDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArticalModel getArticalById(int id) {
        String sql="Select title From article Where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new articalMapper());
    }

    @Override
    public ArrayList<ArticalModel> getNorArticalsWithPic(int limit) {
        String sql = "SELECT * FROM article WHERE ISNULL(cover)=0 " +
                "AND cover!='' ORDER BY created_at DESC LIMIT ?";
        return (ArrayList<ArticalModel>) jdbcTemplate.query(sql,new Object[]{limit},new articalMapper());
    }

    @Override
    public ArrayList<ArticalModel> getNorArticalsByCid(int cid, int pageCount, int limitLine) {
        String sql = "SELECT * FROM article WHERE cid = ? ORDER BY created_at DESC limit ?,?";
        return (ArrayList<ArticalModel>) jdbcTemplate.query(sql,new Object[]{cid,(pageCount-1)*limitLine,limitLine},new articalMapper());
    }


    @Override
    public ArrayList<ArticalModel> getImpArticalsWithPic( int limit) {
        String sql = "SELECT * FROM article where position> 0 AND ISNULL(cover)=0 " +
                "AND cover!='' ORDER BY created_at DESC limit ?";
        return (ArrayList<ArticalModel>) jdbcTemplate.query(sql,new Object[]{limit},new articalMapper());
    }

    //测试数据库的连接时候用的
    @Override
    public String getTitle(int id){
        String sql="Select title From article Where id = ?";
        return jdbcTemplate.queryForObject (sql,new Object[]{id},String.class);
    }
}
