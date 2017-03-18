package cn.nexuslink.dao;

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
        String sql="Select * From artical Where id = ?";
        return null;
    }

    @Override
    public ArrayList<ArticalModel> getNorArticalsByCid(int cid) {
        return null;
    }

    @Override
    public ArrayList<ArticalModel> getImpArticals(int pageCount, int limit) {
        return null;
    }
}
