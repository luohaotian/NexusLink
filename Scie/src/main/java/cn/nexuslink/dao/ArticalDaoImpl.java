package cn.nexuslink.dao;

import cn.nexuslink.dao.mapper.articalMapper;
import cn.nexuslink.model.ArticalDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 罗浩 on 2017/3/18.
 */

@Repository("articalDao")
public class ArticalDaoImpl implements ArticalDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    //@Cacheable(value = "artical")
    public ArticalDO getArticalById(int id) {
        String sql="Select * From article Where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new articalMapper());
    }

    @Override
    @Cacheable(value = "artical")
    public List<ArticalDO> getNorArticalsWithPic(int limit) {
        String sql = "SELECT * FROM article WHERE ISNULL(cover)=0 " +
                "AND cover!='' ORDER BY created_at DESC LIMIT ?";
        return  jdbcTemplate.query(sql,new Object[]{limit},new articalMapper());
    }

    @Override
    @Cacheable(value = "artical")
    public List<ArticalDO> getNorArticalsByCid(int cid, int pageCount, int limitLine) {
        String sql = "SELECT * FROM article WHERE cid = ? ORDER BY created_at DESC limit ?,?";
        return  jdbcTemplate.query(sql,new Object[]{cid,(pageCount-1)*limitLine,limitLine},new articalMapper());
    }


    @Override
    public List<ArticalDO> getImpArticalsWithPic( int limit) {
        String sql = "SELECT * FROM article where position> 0 AND ISNULL(cover)=0 " +
                "AND cover!='' ORDER BY created_at DESC limit ?";
        return  jdbcTemplate.query(sql,new Object[]{limit},new articalMapper());
    }

    //测试数据库的连接时候用的
    @Override
    public String getTitle(int id){
        String sql="Select title From article Where id = ?";
        return jdbcTemplate.queryForObject (sql,new Object[]{id},String.class);
    }
}
