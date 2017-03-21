package cn.nexuslink.dao.rowCallackHandler;

import cn.nexuslink.model.ArticalModel;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**这个没有用处。暂时留着
 * Created by 罗浩 on 2017/3/19.
 */
public class ArticalRowCallbackHandler implements RowCallbackHandler{
    @Override
    public void processRow(ResultSet rs) throws SQLException {
        ArticalModel am = new ArticalModel();
        am.setId(rs.getInt("id"));
        am.setCategoryId(rs.getInt("cid"));
        am.setUserId(rs.getInt("uid"));
        am.setRole(rs.getInt("role"));
        am.setAuthor(rs.getString("author"));
        am.setTitle(rs.getString("title"));
        am.setLink(rs.getInt("link"));
        am.setUrl(rs.getString("url"));
        am.setCover(rs.getString("cover"));
        am.setStatus(rs.getInt("status"));
        am.setModelId(rs.getInt("model_id"));
        am.setPosition(rs.getInt("position"));
        am.setViewCount(rs.getInt("view_count"));
        am.setCommentCount(rs.getInt("comment_count"));
        am.setPublishDate(rs.getDate("publish_date"));
        am.setCopyFrom(rs.getString("copyfrom"));
        am.setContent(rs.getString("content"));
        am.setKeyWords(rs.getString("keywords"));
        am.setDescription(rs.getString("description"));
        am.setVoteId(rs.getInt("vote_id"));
        am.setComment(rs.getInt("comment"));
        am.setCreateAt(rs.getTimestamp("created_at"));
        am.setUpdateAt(rs.getTimestamp("updated_at"));

    }
}
