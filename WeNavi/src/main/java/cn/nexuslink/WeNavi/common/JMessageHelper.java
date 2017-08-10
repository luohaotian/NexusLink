package cn.nexuslink.WeNavi.common;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jiguang.common.resp.ResponseWrapper;
import cn.jiguang.common.utils.StringUtils;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.message.MessageBody;
import cn.jmessage.api.common.model.message.MessagePayload;
import cn.jmessage.api.message.MessageListResult;
import cn.jmessage.api.message.MessageResult;
import cn.jmessage.api.message.MessageType;
import cn.jmessage.api.message.SendMessageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ÂÞºÆ on 2017/8/10.
 */
public class JMessageHelper {
    protected static final Logger LOG = LoggerFactory.getLogger(JMessageHelper.class);

    private static JMessageClient client;
    private static final String appkey = "31b2964462b4db5e14442b9f";
    private static final String masterSecret = "2b0c5f04f3971f0cdfba0e5d";

    public JMessageHelper(){
        JMessageClient client = new JMessageClient(appkey, masterSecret);
    }

    /**
     * Send single text message by admin, this method will invoke sendMessage() in JMessageClient eventually, whose
     * parameters are as list:
     */
    public static void sendSingleTextByAdmin(String toUsername, String fromUsername,String content) {


        try {
            MessageBody body = MessageBody.text(content);
            SendMessageResult result = client.sendSingleTextByAdmin(toUsername, fromUsername, body);
            LOG.info(String.valueOf(result.getMsg_id()));
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    /**
     * Send group text message by admin
     */
    public static void sendGroupTextByAdmin(String targetUsername, String fromUsername,String content) {

        try {
            MessageBody body = MessageBody.text(content);
            SendMessageResult result = client.sendGroupTextByAdmin(targetUsername, fromUsername, body);
            LOG.info(String.valueOf(result.getMsg_id()));
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void sendImageMessage() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        MessageBody messageBody = new MessageBody.Builder()
                .setMediaId("qiniu/image/r/A92D550D57464CDF5ADC0D79FBD46210")
                .setMediaCrc32(4258069839L)
                .setWidth(43)
                .setHeight(44)
                .setFormat("png")
                .setFsize(2670)
                .build();

        MessagePayload payload = MessagePayload.newBuilder()
                .setVersion(1)
                .setTargetType("single")
                .setTargetId("test_user1")
                .setFromType("admin")
                .setFromId("junit_admin")
                .setMessageType(MessageType.IMAGE)
                .setMessageBody(messageBody)
                .build();

        try {
            SendMessageResult res = client.sendMessage(payload);
            System.out.println(res.getMsg_id());
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }

    }

    /**
     * Get message list without cursor(first time), will return cursor, the later request will
     * use cursor to get messages.
     */
    public static void testGetMessageList() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            MessageListResult result = client.getMessageList(10, "2016-09-08 10:10:10", "2016-09-15 10:10:10");
            String cursor = result.getCursor();
            if (null != cursor && StringUtils.isNotEmpty(cursor)) {
                MessageResult[] messages = result.getMessages();
                MessageListResult secondResult = client.getMessageListByCursor(cursor);
                MessageResult[] secondMessages = secondResult.getMessages();
            }
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void testGetUserMessageList() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            MessageListResult result = client.getUserMessages("username", 10, "2016-09-08 10:10:10", "2016-09-15 10:10:10");
            String cursor = result.getCursor();
            MessageListResult secondResult = client.getUserMessagesByCursor("username", cursor);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void testRetractMessage() {
        try {
            ResponseWrapper result = client.retractMessage("username", 12345);
            LOG.info(result.toString());
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }
}
