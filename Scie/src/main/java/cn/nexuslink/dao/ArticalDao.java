package cn.nexuslink.dao;

import cn.nexuslink.model.ArticalDO;

import java.util.List;

/**
 * Created by 罗浩 on 2017/3/18.
 */
public interface ArticalDao {

    /**
     * 通过文章ID得到文章
     * @param id
     * @return
     */
    public ArticalDO getArticalById(int id);

    /**
     * 获得学院主页中新闻快讯中的文章列表，该列表中的新闻必须含有图片
     * @param limit 所需要的文章数
     * @return
     */

    public List<ArticalDO> getNorArticalsWithPic(int limit);

    /**
     * 返回新闻快讯中的子栏目文章列表，实现分页功能
     * @param cid
     * @param pageCount
     * @param limit 所需要的文章数
     * @return
     */
    public List<ArticalDO> getNorArticalsByCid(int cid, int pageCount, int limit);

    /**
     * 返回重点推荐文章列表
     * @param limit 所需要的文章数
     * @return
     */
    public List<ArticalDO> getImpArticalsWithPic(int limit);

    String getTitle(int id);
}
