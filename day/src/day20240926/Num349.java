package day20240926;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author by asia
 * @Classname Num349
 * @Description TODO
 * @Date 2024/9/26 23:15
 */
public class Num349 {

    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums1) {
            set.add(x);
        }
        Set<Integer> set1 = new HashSet<>();
        for (int x : nums2) {
            if (set.contains(x)) {
                set1.add(x);
            }
        }
        int[] ans = new int[set1.size()];
        int index = 0;
        for (Integer integer : set1) {
            ans[index++] = integer;
        }
        return ans;
    }
}
