package cn.nexuslink.dao.mapper;

import cn.nexuslink.model.EasyCategoryVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**简单的栏目信息
 * Created by 罗浩 on 2017/3/19.
 */
public class EasyCategoryMapper implements RowMapper<EasyCategoryVO>{
    @Override
    public EasyCategoryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EasyCategoryVO eam = new EasyCategoryVO();
        eam.setId(rs.getInt("id"));
        eam.setPid(rs.getInt("pid"));
        eam.setTitle(rs.getString("title"));

        return eam;
    }
}
