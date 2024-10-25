package day20241022;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author by asia
 * @Classname Num455
 * @Description TODO
 * @Date 2024/10/22 21:55
 */
public class Num455 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 1};
        System.out.println(new Num455().findContentChildren(a,b));
    }

    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = s.length - 1;
        int j = g.length - 1;
        while (i >= 0) {
            while (j >= 0) {
                if (s[i] >= g[j]) {
                    ++ans;
                    --j;
                    break;
                }
                --j;
            }
            --i;
        }
        return ans;
    }
}
