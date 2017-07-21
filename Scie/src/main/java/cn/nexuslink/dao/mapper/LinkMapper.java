package cn.nexuslink.dao.mapper;

import cn.nexuslink.model.LinkDO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**友情链接
 * Created by 罗浩 on 2017/3/19.
 */
public class LinkMapper implements RowMapper {
    @Override
    public LinkDO mapRow(ResultSet rs, int rowNum) throws SQLException {
        LinkDO lm = new LinkDO();
        lm.setLinkName(rs.getString("title"));
        lm.setUrl(rs.getString("url"));
        return lm;
    }
}
