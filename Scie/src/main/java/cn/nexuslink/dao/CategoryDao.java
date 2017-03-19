package cn.nexuslink.dao;

import cn.nexuslink.model.CategoryModel;
import cn.nexuslink.model.EasyCategoryModel;

import java.util.List;

/**
 * Created by 罗浩 on 2017/3/18.
 */
public interface CategoryDao {
    /**
     * 通过该方法返回栏目表的所有信息，前端能够很简单地进行判别，其余方法均可不用，但暂时保留着，只用这一个方法
     * @return
     */
    public List getAllCategoryList();


    /**
     * 通过一级栏目的id对于二级栏目的pid得到二级栏目列表，里面只包含二级栏目的id与title
     * @param id 一级栏目的id
     * @return
     */

    public List<EasyCategoryModel> getLowCategoryList(int id);

    /**
     * 得到数据库中一级栏目的信息
     * @param limit 学院主页最多容纳的一级栏目个数
     * @return
     */
    public List<EasyCategoryModel> getHighCategoryModel(int limit);

    /**
     * 通过二级栏目自己的id找到对应的栏目信息
     * @param id
     * @return
     */
    public CategoryModel getLowCategoryById(int id );


}
