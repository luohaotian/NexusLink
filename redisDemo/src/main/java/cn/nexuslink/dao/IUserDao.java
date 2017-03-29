package cn.nexuslink.dao;

import cn.nexuslink.pojo.User;

import java.util.List;

/**
 * Created by 罗浩 on 2017/3/29.
 */
public interface IUserDao{


    boolean add(final User user);

    boolean add(List<User> userList);

    void delete(String key);

    void delete(final List<String> keys);

//    boolean update(final User user);
//
//    User get(final String keyId);



}
