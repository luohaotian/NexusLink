package cn.nexuslink.dao.mapper;

import cn.nexuslink.model.CategoryDO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**从数据库获得行所有数据，后续可转换成所需的CategoryMessageModel
 * Created by 罗浩 on 2017/3/19.
 */
public class CategoryMapper implements RowMapper<CategoryDO> {
    @Override
    public CategoryDO mapRow(ResultSet rs, int rowNum) throws SQLException {

        CategoryDO am = new CategoryDO();
        am.setId(rs.getInt("id"));
        am.setName(rs.getString("name"));
        am.setTitle(rs.getString("title"));
        am.setPid(rs.getInt("pid"));
        am.setType(rs.getString("type"));
        am.setModelId(rs.getString("model_id"));
        am.setSort(rs.getInt("sort"));
        am.setContent(rs.getString("content"));
        am.setMetaTitle(rs.getString("meta_title"));
        am.setMetaKeywords(rs.getString("meta_keywords"));
        am.setDescription(rs.getString("meta_description"));
        am.setTemplateIndex(rs.getString("template_index"));
        am.setTemplateList(rs.getString("template_list"));
        am.setTemplateDetail(rs.getString("template_detail"));
        am.setUrl(rs.getString("url"));
        am.setCover(rs.getString("cover"));
        am.setPublish(rs.getInt("publish"));
        am.setDisplay(rs.getInt("display"));
        am.setNav(rs.getInt("nav"));
        am.setCheckLevel(rs.getInt("check_level"));
        am.setDocCount(rs.getInt("doc_count"));

        return am;
    }
}
