package cn.nexuslink.util.conveterUtils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**要求转化的String格式为yyyy-MM-dd hh:MM:ss,即数据库中的created_at时间样式
 * Created by 罗浩 on 2017/3/20.
 */
public class StringToDateConverter implements Converter<String,Date>{

    private String datePattern;


    public StringToDateConverter(String datePattern) {
        this.datePattern=datePattern;
    }

    @Override
    public  Date convert(String s){
            SimpleDateFormat dateFormat = new SimpleDateFormat();
            dateFormat.setLenient(false);
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("StringToDate转换异常！");
        }

    }

}
