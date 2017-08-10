package cn.nexuslink.WeNavi.dao;

import cn.nexuslink.WeNavi.model.form.MessageSendForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 罗浩 on 2017/8/8.
 */
@Repository("messageDao")
public interface IMessageDao {

    /**
     * 添加消息
     * @param message
     * @return
     */
    public int saveMessage(@Param("msg") MessageSendForm message);

    /**
     * 批量修改消息状态
     * @param mids 需要修改的消息mid数组
     * @return
     */
    public int updateStatusBatch(@Param("mids") int[] mids);


    /**
     * 获取用户离线消息列表
     * @param username
     * @return
     */
    public List<Integer> listOfflineMessage(String username);


}
