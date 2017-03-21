package cn.nexuslink.model;

/**返回给浏览器的状态吗常量枚举类
 * Created by 罗浩 on 2017/3/21.
 */
public enum StatusCodeEnum {
    OK(200,"OK"),
    CLIENT_ERROR(400,"客户端请求错误"),
    SERVER_ERROR(500,"服务器错误"),
    No_FOUND(404,"找不到指定资源"),
    VCODE_ERROR(1000,"验证码错误");

    private final int code;
    private final String message;
    StatusCodeEnum(int c,String m) {
        this.code=c;
        this.message=m;
    }
    public int getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }

}
