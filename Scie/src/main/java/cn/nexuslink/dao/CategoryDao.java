package cn.nexuslink.dao;

import cn.nexuslink.model.CategoryDO;
import cn.nexuslink.model.EasyCategoryVO;

import java.util.List;

/**
 * Created by 罗浩 on 2017/3/18.
 */
public interface CategoryDao {

    /**
     * 获得Category表中所有一级栏目和二级栏目的id,pid,name信息放在EasycategoryVO中
     * @return
     */
    public List<EasyCategoryVO> getEasyCategoryList();

    /**
     * 通过栏目d找到对应的栏目信息
     * @param id
     * @return
     */
    public CategoryDO getCategoryById(int id );


}
