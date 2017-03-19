package cn.nexuslink.dao;

import cn.nexuslink.dao.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by 罗浩 on 2017/3/19.
 */

@Repository("linkDao")
public class LinkDaoImpl implements LinkDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<LinkDao> getLinks(int limit) {
        String sql = "SELECT title,url FROM link LIMIT ? ";
        return (ArrayList<LinkDao>) jdbcTemplate.query(sql,new Object[]{limit},new LinkMapper());
    }
}
