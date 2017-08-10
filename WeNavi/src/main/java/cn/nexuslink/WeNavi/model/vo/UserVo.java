package cn.nexuslink.WeNavi.model.vo;

/**description  用于返回好友列表时单个好友视图
 * Created by 罗浩 on 2017/8/8.
 */
public class UserVo {
    private int id;
    private String username;
    private String nickname;
    private String avatar;
    private String login;//用户是否在线
    private String remark;

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", login='" + login + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
