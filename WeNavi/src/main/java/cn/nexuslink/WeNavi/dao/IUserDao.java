package cn.nexuslink.WeNavi.dao;

import cn.nexuslink.WeNavi.model.UserDo;
import cn.nexuslink.WeNavi.model.form.LoginForm;
import cn.nexuslink.WeNavi.model.form.UpdateForm;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Created by �޺� on 2017/8/8.
 */
@Repository("userDao")
public interface IUserDao {
    /**
     * ���user�û�
     * @param user
     * @return
     */
    @Insert("insert into tb_user (username,password,ctime,mtime) values (#{user.username}, #{user.password},#{user.time},#{user.time})")
    public int saveUser(@Param("user") LoginForm user);

    /**
     * ��Ӻ���ʱ����û��Ƿ���ڣ����غ���id
     * @param username  �����û���
     * @return
     */
    @Select("Select uid from tb_user where username = #{username}")
    public int existUser(@Param("username") String username);

    /**
     * ͨ���û�id�ҵ��û�����
     * @param id
     * @return
     */
    @Select("select * from tb_user where id = #{id}")
    @ResultType(UserDo.class)
    public UserDo findUserById(@Param("id") int id);

    /**
     * �û���½ʱͨ���û����ҵ����û�����
     * @param username �û���
     * @return
     */
    @Select("select * from tb_user where username = #{username}")
    @ResultType(UserDo.class)
    public UserDo findUserByUsername(@Param("username") String username);


    /**
     * �����û�������Ϣ
     * @param user ��װ�õ��û�������
     * @return
     */
//    @Update("update tb_user set nickname=#{user.nickname},birthday=#{user.birthday}" +
//            ",gender=#{user.gender},signature=#{user.signature},address=#{user.address},mtime=#{user.mtime} where username=#{user.username}")
    public int updateInfo(@Param("user") UpdateForm user);

    /**
     * �޸��û�����
     * @param username  �û���
     * @param newPassword  ������
     * @return
     */
    @Update("update tb_user set password=#{newPassword} where username=#{username}")
    public int updatePassword(@Param("username") String username, @Param("newPassword") String newPassword);


}
