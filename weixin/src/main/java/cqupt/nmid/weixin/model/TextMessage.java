package cqupt.nmid.weixin.model;

/**创建一个文本类，对用户传过来的数据和我将要给用户传递的数据进行格式统一
 * 方便文本与xml之间的转换
 * Created by 罗浩 on 2017/3/15.
 */
public class TextMessage {
    private  String ToUserName;
    private  String FromUserName;
    private  String CreatTime;
    private  String MsgType;
    private  String Content;
    private  String MsgId;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreatTime() {
        return CreatTime;
    }

    public void setCreatTime(String creatTime) {CreatTime = creatTime;}

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
