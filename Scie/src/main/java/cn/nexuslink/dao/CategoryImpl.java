package cn.nexuslink.dao;

import cn.nexuslink.dao.mapper.CategoryMapper;
import cn.nexuslink.dao.mapper.EasyCategoryMapper;
import cn.nexuslink.model.CategoryModel;
import cn.nexuslink.model.EasyCategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CategoryModel> getAllCategoryList() {
        String sql = "SELECT * FROM category ";
        return jdbcTemplate.query(sql,new CategoryMapper());
    }

    @Override
    public List<EasyCategoryModel> getLowCategoryList(int id) {

        String sql = "SELECT  FROM category WHERE pid =0 ORDER BY id ";
        return jdbcTemplate.query(sql,new Object[]{id},new EasyCategoryMapper());
    }

    @Override
    public List<EasyCategoryModel> getHighCategoryModel(int limit) {
        return null;
    }

    @Override
    public CategoryModel getLowCategoryById(int id) {
        String sql ="SELECT * FROM category WHERE id = ?";
        return (CategoryModel) jdbcTemplate.query(sql,new Object[]{id},new CategoryMapper());
    }
}
