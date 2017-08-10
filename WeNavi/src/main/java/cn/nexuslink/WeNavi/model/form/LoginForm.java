package cn.nexuslink.WeNavi.model.form;

import cn.nexuslink.WeNavi.util.StringUtil;

import java.sql.Timestamp;

/**
 * Created by ÂÞºÆ on 2017/8/8.
 */
public class LoginForm {

    private String username;
    private String password;
    private Timestamp time;

    @Override
    public String toString() {
        return "LoginForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", time=" + time +
                '}';
    }

    public boolean validate(){
        return !StringUtil.isEmpty(username)
                && !StringUtil.isEmpty(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
