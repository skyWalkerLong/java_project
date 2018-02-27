package coreTechCode.date;

import java.util.Calendar;

/**
 * @Author longchao
 * @Date 2018/2/7.
 */
public class Time {

    public static void main(String[] args) {
        System.out.println(DateUtils.getDate("yyyy-MM-dd", Calendar.DATE, -1));//昨日
    }
}
