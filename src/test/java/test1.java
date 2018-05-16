import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author longchao
 * @date 2018/4/3.
 */
public class test1 {
    public static void main(String[] args) {
        int hour = 0;
        int min = 0;
        ArrayList<String> list = new ArrayList<>();
        printX_AXIS(hour,min,list);
        //printRANGE(hour,min,list);
       // printTOTAL_RANGE(hour,min,list);

//        int size = list.size();
//        String[] strings = (String[]) list.toArray(new String[size]);
//        System.out.println(Arrays.toString(strings));
    }

//    private static void interval5min(int hour,int min,ArrayList<String> list) {
//        while (min < 60 && hour < 24) {
//            if (min < 10) {
//                list.add(hour + ":0" + min);
//            } else {
//                list.add(hour+":"+min);
//            }
//            min = min+5;
//            if (min == 60) {
//                min = 0;
//                hour = hour+1;
//            }
//        }

   private static void printX_AXIS(int hour,int min,ArrayList<String> list) {
        while (min < 60 && hour < 24) {
            if (min < 10) {
                list.add(hour + ":0" + min);
            } else {
                list.add(hour+":"+min);
            }
            min = min+5;
            if (min == 60) {
                min = 0;
                hour = hour+1;
            }
        }

        list.forEach(i -> System.out.print('"'+i+'"'+","));
    }

    private static void printRANGE(int hour,int min,ArrayList<String> list) {
        while (min < 60 && hour < 24) {
            StringBuilder sb = new StringBuilder();
            if(min < 10) {
                sb.append(hour + ":0" + min + "~");
            } else {
                sb.append(hour + ":" + min + "~");
            }
            min = min +4;
            if(min < 10) {
                sb.append(hour + ":0" + min );
            } else {
                sb.append(hour + ":" + min );
            }
            list.add(sb.toString());
            min = min + 1;
            if (min == 60) {
                min = 0;
                hour = hour+1;
            }

        }
        list.forEach(i -> System.out.print('"'+i+'"'+","));
    }

    private static void printTOTAL_RANGE(int hour,int min,ArrayList<String> list) {
        while (min < 60 && hour < 24) {
            StringBuilder sb = new StringBuilder();
            sb.append("0:00"+"~");
            min = min +4;
            if(min < 10) {
                sb.append(hour + ":0" + min );
            } else {
                sb.append(hour + ":" + min );
            }
            list.add(sb.toString());
            min = min + 1;
            if (min == 60) {
                min = 0;
                hour = hour+1;
            }

        }
        list.forEach(i -> System.out.print('"'+i+'"'+","));
    }

}
