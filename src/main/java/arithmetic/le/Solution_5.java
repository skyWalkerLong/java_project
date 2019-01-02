package arithmetic.le;

import org.junit.Test;

/**
 * 最长回文子串
 *
 * @author Long Chao
 * @version 1.0
 * @data 2019-01-02
 */
public class Solution_5 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0, len =0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = handler(s,i,i);
            int len2 = handler(s,i,i+1);
            int temp = Math.max(len1,len2);
            if (temp > len) {
                len = temp;
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start,end+1);
    }

    int handler(String s, int i, int j) {
        int left = i;
        int right = j;
        int length = s.length();

        while (left >= 0 && right <length && left <= right && (s.charAt(left) == s.charAt(right))) {
            right++;
            left--;
        }

        return right - left - 1;

    }

    @Test
    public void test () {
        Solution_5 l = new Solution_5();
        System.out.println(l.longestPalindrome("cabbad"));

    }
}
