package cn.nexuslink.WeNavi.common;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jiguang.common.resp.ResponseWrapper;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.RegisterInfo;
import cn.jmessage.api.common.model.friend.FriendNote;
import cn.jmessage.api.user.UserInfoResult;
import cn.jmessage.api.user.UserStateResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ÂÞºÆ on 2017/8/10.
 */
public class JUserHelper {

    protected static final Logger LOG = LoggerFactory.getLogger(JUserHelper.class);

    private static JMessageClient client;
    private static final String appkey = "31b2964462b4db5e14442b9f";
    private static final String masterSecret = "2b0c5f04f3971f0cdfba0e5d";

    public JUserHelper(){
        client = new JMessageClient(appkey, masterSecret);
    }

    public static void main(String[] args) {
       //registerUsers("Rye2017","rye140610");
    }

    public static void registerUsers(String username, String password) {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {

            List<RegisterInfo> users = new ArrayList<RegisterInfo>();

            RegisterInfo user = RegisterInfo.newBuilder()
                    .setUsername(username)
                    .setPassword(password)
                    .build();

            users.add(user);

            RegisterInfo[] regUsers = new RegisterInfo[users.size()];

            String res = client.registerUsers(users.toArray(regUsers));
            LOG.info(res);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void getUserInfo(String username) {
        try {
            UserInfoResult res = client.getUserInfo(username);
            LOG.info(res.getUsername());
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void getUserState(String username) {

        try {
            UserStateResult result = client.getUserState(username);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void testUpdatePassword(String username,String new_pas) {

        try {
            client.updateUserPassword(username, new_pas);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void updateUserInfo() {

        try {
            client.updateUserInfo("test_user", "test_nick", "2000-01-12", "help me!", 1, "shenzhen", "nanshan");
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void deleteUser(String username) {

        try {
            client.deleteUser(username);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void addFriend(String username) {

        try {
            ResponseWrapper response = client.addFriends(username);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void deleteFriend(String username) {

        try {
            ResponseWrapper response = client.deleteFriends(username);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void updateFriendsNote(String username,String friendUsername,String remark) {
        try {
            List<FriendNote> friendNotes = new ArrayList<FriendNote>();
            FriendNote friendNote1 = new FriendNote.Builder()
                    .setNoteName(remark)
                    .setOthers(username)
                    .setUsername(friendUsername)
                    .builder();

            friendNotes.add(friendNote1);
            FriendNote[] array = new FriendNote[friendNotes.size()];
            ResponseWrapper result = client.updateFriendsNote(username, friendNotes.toArray(array));
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static UserInfoResult[] getFriends(String username) {
        try {
            UserInfoResult[] userInfoArray = client.getFriendsInfo(username);
            return userInfoArray;
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            return null;
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
            return null;
        }
    }
}
