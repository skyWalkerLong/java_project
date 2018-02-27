package coreTechCode.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author longchao
 * @Date 2018/2/7.
 */

/**
 * 获取时间工具类
 */
public class DateUtils {

    public static String getDate(String pattern,int ymd,int count) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(ymd,count);
        Date date = calendar.getTime();
        return format.format(date);
    }

}
