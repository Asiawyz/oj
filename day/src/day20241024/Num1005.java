package day20241024;

import java.util.Arrays;

/**
 * @author by asia
 * @Classname Num1005
 * @Description TODO
 * @Date 2024/10/24 17:28
 */
public class Num1005 {

    public static void main(String[] args) {

    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int index = 0;
        while (k > 0 && index < n && nums[index] < 0) {
            --k;
            nums[index] = -nums[index];
            ++index;
        }
        Arrays.sort(nums);
        if (k % 2 != 0) {
            nums[0] = -nums[0];
        }
        int count = 0;
        for (int x : nums) {
            count += x;
        }
        return count;
    }
}
