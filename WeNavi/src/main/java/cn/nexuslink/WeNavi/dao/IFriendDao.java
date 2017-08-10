package cn.nexuslink.WeNavi.dao;

import cn.nexuslink.WeNavi.model.vo.UserVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 罗浩 on 2017/8/8.
 */
public interface IFriendDao {

    /**
     * 两用户相互添加好友
     * @param id1
     * @param id2
     */
    @Insert("insert into tb_friend (user_id.friend_id) values (#{userId},#{friendId})")
    public void saveFriendship(@Param("userId") int id1, @Param("friendId") int id2);

    /**
     * 删除好友
     * @param id1  用户id
     * @param id2  被删除好友id
     */
    @Delete("delete from tb_user where user_id=#{userId} and friend_id=#{friendId}")
    public void deleteFriendship(@Param("userId") int id1, @Param("friendId") int id2);

    /**
     * 修改好友备注
     *
     * @param id1
     * @param id2
     * @param remark
     */
    @Update("update tb_friend set remark=#{remark} where user_id=#{userId} and friend_id=#{friendId}")
    public void remarkFriend(@Param("userId") int id1,@Param("friendId") int id2,@Param("remark") String remark);

    /**
     * 返回用户好友列表，未采用分页
     * @param username 用户名
     * @return
     */
    public List<UserVo> listFriends(@Param("username") String username);
}
