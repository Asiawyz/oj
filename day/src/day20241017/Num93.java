package day20241017;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by asia
 * @Classname Num93
 * @Description TODO
 * @Date 2024/10/17 16:42
 */
public class Num93 {

    public static void main(String[] args) {
        System.out.println(check("023"));
        String s = "101023";
        new Num93().restoreIpAddresses(s);
    }

    List<String> ans;
    List<String> tmp;
    int n;
    String str;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        tmp = new ArrayList<>(4);
        if (s.length() < 4) {
            return ans;
        }
        n = s.length();
        str = s;
        dfs(0, 0);
        return ans;
    }

    public void dfs(int x, int left) {
        if (left == n && x == 4) {
            StringBuilder s = new StringBuilder();
            for (String ss : tmp) {
                s.append(ss).append(".");
            }
            System.out.println(s.substring(0,n + 3));
            ans.add(s.substring(0, n + 3));
            return;
        }
        if (x == 4) {
            return;
        }
        if (left == n) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (left + i - 1 == n) {
                break;
            }
            String s = str.substring(left, left + i);
            if (check(s)) {
                tmp.add(s);
                dfs(x + 1, left + i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static boolean check(String str) {
        int x = Integer.parseInt(str);
        if (x > 255) {
            return false;
        }
        return !str.startsWith("0") || str.length() <= 1;
    }




}
