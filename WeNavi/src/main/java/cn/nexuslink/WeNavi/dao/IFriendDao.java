package cn.nexuslink.WeNavi.dao;

import cn.nexuslink.WeNavi.model.vo.UserVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by �޺� on 2017/8/8.
 */
public interface IFriendDao {

    /**
     * ���û��໥��Ӻ���
     * @param id1
     * @param id2
     */
    @Insert("insert into tb_friend (user_id.friend_id) values (#{userId},#{friendId})")
    public void saveFriendship(@Param("userId") int id1, @Param("friendId") int id2);

    /**
     * ɾ������
     * @param id1  �û�id
     * @param id2  ��ɾ������id
     */
    @Delete("delete from tb_user where user_id=#{userId} and friend_id=#{friendId}")
    public void deleteFriendship(@Param("userId") int id1, @Param("friendId") int id2);

    /**
     * �޸ĺ��ѱ�ע
     *
     * @param id1
     * @param id2
     * @param remark
     */
    @Update("update tb_friend set remark=#{remark} where user_id=#{userId} and friend_id=#{friendId}")
    public void remarkFriend(@Param("userId") int id1,@Param("friendId") int id2,@Param("remark") String remark);

    /**
     * �����û������б�δ���÷�ҳ
     * @param username �û���
     * @return
     */
    public List<UserVo> listFriends(@Param("username") String username);
}
