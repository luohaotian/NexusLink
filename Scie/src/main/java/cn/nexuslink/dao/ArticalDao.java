package cn.nexuslink.dao;

import cn.nexuslink.model.ArticalModel;

import java.util.ArrayList;

/**
 * Created by 罗浩 on 2017/3/18.
 */
public interface ArticalDao {

    /**
     * 通过文章ID得到文章
     * @param id
     * @return
     */
    public ArticalModel getArticalById(int id);

    /**
     * 获得学院主页中新闻快讯中的文章列表，该列表中的新闻必须含有图片
     * @param limit
     * @return
     */

    public ArrayList<ArticalModel> getNorArticalsWithPic(int limit);

    /**
     * 返回新闻快讯中的文章列表，实现分页功能
     * @param cid
     * @param pageCount
     * @param limit
     * @return
     */
    public ArrayList<ArticalModel> getNorArticalsByCid(int cid, int pageCount, int limit);

    /**
     * 返回重点推荐文章列表
     * @param limit
     * @return
     */
    public ArrayList<ArticalModel> getImpArticalsWithPic(int limit);

    String getTitle(int id);
}
