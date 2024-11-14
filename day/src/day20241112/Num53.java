package day20241112;

/**
 * @author by asia
 * @Classname Num53
 * @Description TODO
 * @Date 2024/11/12 13:50
 */
public class Num53 {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int pre = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
