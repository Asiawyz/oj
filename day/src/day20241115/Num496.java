package day20241115;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author by asia
 * @Classname Num496
 * @Description TODO
 * @Date 2024/11/15 14:51
 */
public class Num496 {

    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums2[0], 0);
        Arrays.fill(ans, -1);
        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty()) {
                int x = deque.peekLast();
                int y = nums2[x];
                if (nums2[i] > y) {
                    ans[x] = nums2[i];
                    deque.removeLast();
                } else {
                    break;
                }
            }
            map.put(nums2[i], i);
            deque.addLast(i);
        }
        int m = nums1.length;
        int[] f = new int[m];

        for (int i = 0; i < m; i++) {
            int index = map.get(nums1[i]);
            f[i] = ans[index];
        }
        return f;
    }
}
