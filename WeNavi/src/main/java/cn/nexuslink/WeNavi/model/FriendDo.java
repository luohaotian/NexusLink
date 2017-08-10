package cn.nexuslink.WeNavi.model;

/**
 * Created by ÂÞºÆ on 2017/8/8.
 */
public class FriendDo {

    private int userId;
    private  int friendId;
    private String group;
    private String remark;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FriendDo{" +
                "userId=" + userId +
                ", friendId=" + friendId +
                ", group='" + group + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
