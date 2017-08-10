package cn.nexuslink.WeNavi.model.form;

import cn.nexuslink.WeNavi.util.StringUtil;

import java.sql.Timestamp;

/**
 * Created by ÂÞºÆ on 2017/8/8.
 */
public class MessageSendForm {

    private String fromUsername;
    private String toUsername;
    private char targetType;
    private char msgType;
    private String content;
    private int offline;
    private Timestamp ctime;

    private boolean validate(){
        return !StringUtil.isEmpty(fromUsername)
                && !StringUtil.isEmpty(toUsername)
                && !StringUtil.isEmpty(content);
    }

    @Override
    public String toString() {
        return "MessageSendForm{" +
                "fromUsername='" + fromUsername + '\'' +
                ", toUsername='" + toUsername + '\'' +
                ", targetType=" + targetType +
                ", msgType=" + msgType +
                ", content='" + content + '\'' +
                ", offline=" + offline +
                ", ctime=" + ctime +
                '}';
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
