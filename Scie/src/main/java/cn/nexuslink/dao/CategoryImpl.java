package cn.nexuslink.dao;

import cn.nexuslink.dao.mapper.CategoryMapper;
import cn.nexuslink.dao.mapper.EasyCategoryMapper;
import cn.nexuslink.model.CategoryDO;
import cn.nexuslink.model.EasyCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**获取主页所有栏目信息
 * Created by 罗浩 on 2017/3/19.
 */

@Repository("categoryDao")
public class CategoryImpl implements  CategoryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Cacheable(value = "category")
    public List<EasyCategoryVO> getEasyCategoryList() {
        String sql = "Select id,title,pid FROM category ";
        return jdbcTemplate.query(sql,new EasyCategoryMapper());
    }

    @Override
    public CategoryDO getCategoryById(int id) {
        String sql = "Select * FROM  category where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CategoryMapper());
    }

}
