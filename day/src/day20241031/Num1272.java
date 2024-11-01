package day20241031;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num1272
 * @Description TODO
 * @Date 2024/10/31 20:17
 */
public class Num1272 {

    public static void main(String[] args) {
        int[][] a = {{-5,-4},{-3,-2},{1,2},{3,5},{8,9}};
        int[] b = {-1, 4};
        for (List<Integer> tmp : new Num1272().removeInterval(a, b)) {
            System.out.println(tmp.get(0) + " " + tmp.get(1));
        }
    }

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int left = toBeRemoved[0], right = toBeRemoved[1];
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] a : intervals) {
            int x = a[0], y = a[1];
            if (x >= left && y <= right) {
                continue;
            }
            if (x >= right || left >= y) {
                add(ans, x, y);
                continue;
            }
            if (x < left && y > right) {
                add(ans, x, left);
                add(ans, right, y);
                continue;
            }
            if (x < left) {
                add(ans, x, left);
                continue;
            }
            add(ans, right, y);
        }
        return ans;
    }

    public void add(List<List<Integer>> ans, int x, int y) {
        List<Integer> tmp = new ArrayList<>(2);
        tmp.add(x);
        tmp.add(y);
        ans.add(tmp);
    }
}
