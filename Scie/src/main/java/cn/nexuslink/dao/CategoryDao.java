package cn.nexuslink.dao;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by 罗浩 on 2017/3/18.
 */
public interface CategoryDao {
    /**
     * 返回栏目列表，将一级栏目作为key,将对应的二级栏目list作为value
     * @return
     */

    public Map<String,ArrayList<String>> getCategoryList();


}
