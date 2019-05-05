package arithmetic.le;

import org.junit.Test;

/**
 * TODO some word
 *
 * @author Long Chao
 * @version 1.0
 * @data 2019-01-05
 */
public class Solution_7 {
    public int reverse(int x) {
        if (x == 0) return 0;
        String s = String.valueOf(x);
        int n = s.length();
        if (n ==0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        Boolean isNegative = false;
        int isZero = 1;

        if (String.valueOf(s.charAt(0)).equals("-")) {
            s = s.substring(1,n);
            n = n - 1;
            isNegative = true;
        }
        for (int i = n-1; i >= 0; i--) {
            if (! "0".equals(String.valueOf(s.charAt(i)))) {
                isZero--;
            }
            if (isZero < 1) {
                sb.append(s.charAt(i));
            }
        }

        if (isNegative) {
            sb.insert(0,"-");
        }

        Long temp = Long.valueOf(sb.toString());

        if (temp >= Math.pow(-2,31) && temp <= (Math.pow(2,31) - 1)) {
            return temp.intValue();
        }

        return 0;

    }

    @Test
    public void test () {
        int x = 1534236469;

//        StringBuilder sb = new StringBuilder(String.valueOf(x));
//        System.out.println(sb.insert(0,"-"));
        System.out.println(reverse(x));
    }
}
