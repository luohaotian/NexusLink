package cn.nexuslink.dao;

import cn.nexuslink.dao.mapper.EasyCategoryMapper;
import cn.nexuslink.model.EasyCategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 罗浩 on 2017/3/19.
 */

@Repository("categoryDao")
public class CategoryImpl implements  CategoryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<EasyCategoryModel> getLowCategoryList(int id) {

        String sql = "SELECT  FROM category WHERE pid =0 ORDER BY id ";
        return jdbcTemplate.query(sql,new Object[]{id},new EasyCategoryMapper());
    }
}
