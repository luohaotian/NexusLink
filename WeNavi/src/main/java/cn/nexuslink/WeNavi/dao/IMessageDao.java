package cn.nexuslink.WeNavi.dao;

import cn.nexuslink.WeNavi.model.form.MessageSendForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by �޺� on 2017/8/8.
 */
@Repository("messageDao")
public interface IMessageDao {

    /**
     * �����Ϣ
     * @param message
     * @return
     */
    public int saveMessage(@Param("msg") MessageSendForm message);

    /**
     * �����޸���Ϣ״̬
     * @param mids ��Ҫ�޸ĵ���Ϣmid����
     * @return
     */
    public int updateStatusBatch(@Param("mids") int[] mids);


    /**
     * ��ȡ�û�������Ϣ�б�
     * @param username
     * @return
     */
    public List<Integer> listOfflineMessage(String username);


}
