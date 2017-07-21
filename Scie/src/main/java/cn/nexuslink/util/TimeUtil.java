package cn.nexuslink.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 罗浩 on 2017/7/19.
 * description 用来讲从数据库中的返回的timestamp类型转化为字符串类型，方便截取
 */
public class TimeUtil {

    public static String timestamp2String(Timestamp timestamp){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
        return df.format(timestamp);
    }

    public static Timestamp getTimestamp(){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        Timestamp ts = Timestamp.valueOf(time);
        return ts;
    }

    public static String GetNowTime() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(now);
    }

    public static void main(String[] args) {
        System.out.println(TimeUtil.GetNowTime());
        System.out.println(new Date());
        System.out.println(TimeUtil.getTimestamp());
        long time = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(time);
        String str = TimeUtil.timestamp2String(timestamp);
        System.out.println(str.substring(0,10));

    }
}
