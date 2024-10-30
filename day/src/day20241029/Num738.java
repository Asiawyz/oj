package day20241029;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num738
 * @Description TODO
 * @Date 2024/10/29 13:08
 */
public class Num738 {

    public static void main(String[] args) {
        System.out.println(new Num738().monotoneIncreasingDigits(1234));
    }

    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;
        for (int i = len - 2; i >= 0; --i) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                len = i + 1;
            }
        }
        for (int i = len; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

}
