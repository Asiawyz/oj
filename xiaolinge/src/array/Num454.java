package array;

import java.util.HashMap;
import java.util.Map;

public class Num454 {

    public static void main(String[] args) {

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int k : nums1) {
            for (int i : nums2) {
                int x = k + i;
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        int ans = 0;
        for (int k : nums3) {
            for (int i : nums4) {
                int x = k + i;
                if (map.containsKey(-x)) {
                    ans += map.get(-x);
                }
            }
        }
        return ans;
    }
}
