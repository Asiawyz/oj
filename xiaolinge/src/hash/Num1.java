package hash;

import java.util.HashMap;
import java.util.Map;

public class Num1 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                ans[0] = map.get(target - x);
                ans[1] = i;
                break;
            } else {
                map.put(x, i);
            }
        }
        return ans;
    }
}
