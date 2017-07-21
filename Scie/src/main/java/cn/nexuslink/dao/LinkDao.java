package cn.nexuslink.dao;

import cn.nexuslink.model.LinkDO;

import java.util.ArrayList;

/**
 * Created by 罗浩 on 2017/3/18.
 */
public interface LinkDao {
    /**
     * 得到友情链接集合list
     * @param limit 友情链接返回个数
     * @return
     */
    public ArrayList<LinkDO> getLinks(int limit);
}
