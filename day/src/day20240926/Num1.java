package day20240926;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by asia
 * @Classname Num1
 * @Description TODO
 * @Date 2024/9/27 0:35
 */
public class Num1 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null){
                map.put(target - nums[i],i);
            }
            else{
                ans = new int[]{map.get(nums[i]), i};
            }
        }
        return ans;
    }

}
