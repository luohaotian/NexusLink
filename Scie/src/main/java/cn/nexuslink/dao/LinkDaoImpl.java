package cn.nexuslink.dao;

import cn.nexuslink.dao.mapper.LinkMapper;
import cn.nexuslink.model.LinkDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "link")
    public ArrayList<LinkDO> getLinks(int limit) {
        String sql = "SELECT title,url FROM link LIMIT ? ";
        return (ArrayList<LinkDO>) jdbcTemplate.query(sql,new Object[]{limit},new LinkMapper());
    }
}
