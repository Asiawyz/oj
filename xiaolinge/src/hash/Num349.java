package hash;

import java.util.HashSet;
import java.util.Set;

public class Num349 {

    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int x : nums2) {
            if (set1.contains(x)) {
                set2.add(x);
            }
        }
        int[] ans = new int[set2.size()];
        int i = 0;
        for (int x : set2) {
            ans[i++] = x;
        }
        return ans;
    }
}
