package cn.nexuslink.dao.mapper;

import cn.nexuslink.model.ArticalModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 罗浩 on 2017/3/18.
 */
public class articalMapper implements RowMapper<ArticalModel> {

    @Override
    public ArticalModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        ArticalModel am = new ArticalModel();
        am.setId(rs.getInt("id"));
        am.setCategoryId(rs.getInt("categoryId"));
        am.setUserId(rs.getInt("userId"));
        am.setRole(rs.getInt("role"));
        am.setAuthor(rs.getString("author"));
        am.setTitle(rs.getString("title"));
        am.setContent(rs.getString("content"));
        am.setLink(rs.getInt("link"));
        am.setUrl(rs.getString("url"));


        return null;
    }
}
