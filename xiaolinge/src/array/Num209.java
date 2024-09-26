package array;

/**
 * @author by asia
 * @Classname Num209
 * @Description Num209
 * @Date 2024/9/26 12:24
 */
public class Num209 {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 4, 3};
        System.out.println(new Num209().minSubArrayLen(7, a));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int count = nums[0];
        if (count >= target) {
            return 1;
        }
        int left = 0, right = 0, n = nums.length;
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            ++right;
            if (right == n) {
                break;
            }
            if (nums[right] >= target) {
                return 1;
            }
            count += nums[right];
            while (count >= target && left < right) {
                ans = Math.min(ans, right - left + 1);
                count -= nums[left++];
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }

}
