package cn.nexuslink.WeNavi.dao;

import cn.nexuslink.WeNavi.model.UserDo;
import cn.nexuslink.WeNavi.model.form.LoginForm;
import cn.nexuslink.WeNavi.model.form.UpdateForm;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Created by 罗浩 on 2017/8/8.
 */
@Repository("userDao")
public interface IUserDao {
    /**
     * 添加user用户
     * @param user
     * @return
     */
    @Insert("insert into tb_user (username,password,ctime,mtime) values (#{user.username}, #{user.password},#{user.time},#{user.time})")
    public int saveUser(@Param("user") LoginForm user);

    /**
     * 添加好友时检测用户是否存在，返回好友id
     * @param username  好友用户名
     * @return
     */
    @Select("Select uid from tb_user where username = #{username}")
    public int existUser(@Param("username") String username);

    /**
     * 通过用户id找到用户对象
     * @param id
     * @return
     */
    @Select("select * from tb_user where id = #{id}")
    @ResultType(UserDo.class)
    public UserDo findUserById(@Param("id") int id);

    /**
     * 用户登陆时通过用户名找到该用户对象
     * @param username 用户名
     * @return
     */
    @Select("select * from tb_user where username = #{username}")
    @ResultType(UserDo.class)
    public UserDo findUserByUsername(@Param("username") String username);


    /**
     * 更新用户基本信息
     * @param user 封装好的用户表单对象
     * @return
     */
//    @Update("update tb_user set nickname=#{user.nickname},birthday=#{user.birthday}" +
//            ",gender=#{user.gender},signature=#{user.signature},address=#{user.address},mtime=#{user.mtime} where username=#{user.username}")
    public int updateInfo(@Param("user") UpdateForm user);

    /**
     * 修改用户密码
     * @param username  用户名
     * @param newPassword  新密码
     * @return
     */
    @Update("update tb_user set password=#{newPassword} where username=#{username}")
    public int updatePassword(@Param("username") String username, @Param("newPassword") String newPassword);


}
