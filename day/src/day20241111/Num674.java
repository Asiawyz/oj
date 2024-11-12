package day20241111;

/**
 * @author by asia
 * @Classname Num674
 * @Description TODO
 * @Date 2024/11/11 11:29
 */
public class Num674 {

    public static void main(String[] args) {

    }


    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                ++len;
                ans = Math.max(ans, len);
            } else {
                len = 1;
            }
        }
        return ans;
    }

}
