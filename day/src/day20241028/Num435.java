package day20241028;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author by asia
 * @Classname Num435
 * @Description TODO
 * @Date 2024/10/28 20:03
 */
public class Num435 {

    public static void main(String[] args) {
        int[][] a = {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        System.out.println(new Num435().eraseOverlapIntervals(a));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (left >= end) {
                end = right;
                continue;
            }
            if (right < end) {
                end = right;
            }
            ++ans;
        }
        return ans;
    }
}
