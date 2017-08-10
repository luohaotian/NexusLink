package cn.nexuslink.WeNavi.model.vo;

import java.util.Arrays;

/**
 * Created by ÂÞºÆ on 2017/8/8.
 */
public class FrienshipVo {

    private int uid;
    private String username;

    private UserVo[] friend;

    @Override
    public String toString() {
        return "FrienshipVo{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", friend=" + Arrays.toString(friend) +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserVo[] getFriend() {
        return friend;
    }

    public void setFriend(UserVo[] friend) {
        this.friend = friend;
    }
}
