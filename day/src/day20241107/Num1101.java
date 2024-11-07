package day20241107;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author by asia
 * @Classname Num1101
 * @Description TODO
 * @Date 2024/11/7 20:12
 */
public class Num1101 {

    public static void main(String[] args) {

    }

    int[] f;
    int[] nums;
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (Comparator.comparingInt(o -> o[0])));
        f = new int[n];
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
            nums[i] = 1;
        }
        for (int[] log : logs) {
            int time = log[0];
            int x = log[1];
            int y = log[2];
            int xx = find(x);
            int yy = find(y);
            if (xx != yy) {
                f[xx] = yy;
                nums[yy] += nums[xx];
                if (nums[yy] == n) {
                    return time;
                }
            }
        }
        return -1;
    }

    public int find(int x) {
        if (f[x] == x) {
            return x;
        }
        f[x] = find(f[x]);
        return f[x];
    }
}


