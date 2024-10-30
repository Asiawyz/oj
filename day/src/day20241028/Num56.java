package day20241028;

import java.util.*;

/**
 * @author by asia
 * @Classname Num56
 * @Description TODO
 * @Date 2024/10/28 21:19
 */
public class Num56 {

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {1, 2}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = new Num56().merge(a);
        for (int[] b : merge) {
            System.out.println(b[0] + " " + b[1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            }
            if (o1[0] < o2[0]) {
                return -1;
            }
            return o1[1] - o2[1];
        });
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (left > end) {
                ans.add(new int[]{start, end});
                start = left;
                end = right;
            } else {
                end = Math.max(right, end);
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][2]);
    }
}
