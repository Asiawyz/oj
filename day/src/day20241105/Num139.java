package day20241105;

import java.util.Arrays;
import java.util.List;

/**
 * @author by asia
 * @Classname Num139
 * @Description TODO
 * @Date 2024/11/5 15:45
 */
public class Num139 {

    public static void main(String[] args) {
        String s = "catsandog";
        String[] ss = {"cats", "dog", "sand", "and", "cat"};
        System.out.println(new Num139().wordBreak(s, Arrays.asList(ss)));
    }


    int[][] flag;
    List<String> words;
    String s;
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        flag = new int[len][len];
        words = wordDict;
        this.s = s;
        return check(0, len - 1);
    }

    public boolean check(int left, int right) {
        if (left > right) {
            return true;
        }
        if (flag[left][right] != 0) {
            return flag[left][right] == 1;
        }
        String str = s.substring(left, right + 1);
        for (String ss : words) {
            if (!str.contains(ss)) {
                continue;
            }
            if (str.equals(ss)) {
                flag[left][right] = 1;
                return true;
            }
            int index = str.indexOf(ss);
            if (check(left, left + index - 1) && check(left + index + ss.length(), right)) {
                flag[left][right] = 1;
                return true;
            }
        }
        flag[left][right] = 2;
        return false;
    }
}
