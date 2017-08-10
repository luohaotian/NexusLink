package cn.nexuslink.WeNavi.model;

import java.sql.Timestamp;

/**
 * Created by ÂÞºÆ on 2017/8/8.
 */
public class MessageDo {

    private int mid;
    private String fromUsername;
    private String toUsername;
    private char targetType;
    private char msgType;
    private String content;
    private int offline;
    private Timestamp ctime;

    @Override
    public String toString() {
        return "MessageDo{" +
                "mid=" + mid +
                ", fromUsername='" + fromUsername + '\'' +
                ", toUsername='" + toUsername + '\'' +
                ", targetType=" + targetType +
                ", msgType=" + msgType +
                ", content='" + content + '\'' +
                ", offline=" + offline +
                ", ctime=" + ctime +
                '}';
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
    }

    public char getTargetType() {
        return targetType;
    }

    public void setTargetType(char targetType) {
        this.targetType = targetType;
    }

    public char getMsgType() {
        return msgType;
    }

    public void setMsgType(char msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOffline() {
        return offline;
    }

    public void setOffline(int offline) {
        this.offline = offline;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }
}
