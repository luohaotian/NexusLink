package cn.nexuslink.WeNavi.model.form;

import cn.nexuslink.WeNavi.util.StringUtil;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by ÂÞºÆ on 2017/8/8.
 */
public class UpdateForm {

    private String username;
    private String nickname;
    private Date birthday;
    private int gender;
    private String signature;
    private String address;
    private Timestamp mtime;

    public boolean vadilate(){
        return !StringUtil.isEmpty(username)
                && (!StringUtil.isEmpty(nickname) ||
                !StringUtil.isEmpty(birthday.toString()) || !StringUtil.isEmpty(signature) ||
                !StringUtil.isEmpty(address));
    }

    @Override
    public String toString() {
        return "UpdateForm{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", signature='" + signature + '\'' +
                ", address='" + address + '\'' +
                ", mtime=" + mtime +
                '}';
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getMtime() {
        return mtime;
    }

    public void setMtime(Timestamp mtime) {
        this.mtime = mtime;
    }
}
