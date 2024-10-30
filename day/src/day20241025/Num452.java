package day20241025;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author by asia
 * @Classname Num452
 * @Description TODO
 * @Date 2024/10/25 22:55
 */
public class Num452 {

    public static void main(String[] args) {

    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            }
            if (o1[0] < o2[0]) {
                return -1;
            }
            return o1[1] - o2[1];
        });
        int count = 1;
        int start = points[0][0], end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int left = points[i][0], right = points[i][1];
            if (left > end) {
                ++count;
                start = left;
                end = right;
            } else {
                start = left;
                end = Math.min(end, right);
            }
        }
        return count;
    }

}
