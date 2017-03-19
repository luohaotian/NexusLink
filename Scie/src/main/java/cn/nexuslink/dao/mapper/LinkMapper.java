package cn.nexuslink.dao.mapper;

import cn.nexuslink.model.LinkModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**友情链接
 * Created by 罗浩 on 2017/3/19.
 */
public class LinkMapper implements RowMapper {
    @Override
    public LinkModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        LinkModel lm = new LinkModel();
        lm.setLinkName(rs.getString("title"));
        lm.setUrl(rs.getString("url"));
        return lm;
    }
}
