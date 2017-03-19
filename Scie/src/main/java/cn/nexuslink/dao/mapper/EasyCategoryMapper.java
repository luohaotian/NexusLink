package cn.nexuslink.dao.mapper;

import cn.nexuslink.model.EasyCategoryModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**简单的栏目信息
 * Created by 罗浩 on 2017/3/19.
 */
public class EasyCategoryMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        EasyCategoryModel eam = new EasyCategoryModel();
        eam.setId(rs.getInt("id"));
        eam.setPid(rs.getInt("pid"));
        eam.setTitle(rs.getString("title"));

        return eam;
    }
}
