package hash;

public class Num53 {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int ans = f[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(nums[i], nums[i] + f[i - 1]);
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
