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
     * 通过栏目id和当前页数以及所需行数得到对应栏目分页后的文章列表
     * @param cid
     * @return
     */
    public ArrayList<ArticalModel> getNorArticalsByCid(int cid);

    /**
     * 通过当前页数和所需行数得到重点推荐的文章分页后的列表
     * @param pageCount
     * @param limit
     * @return
     */
    public ArrayList<ArticalModel> getImpArticals(int pageCount,int limit);

}
