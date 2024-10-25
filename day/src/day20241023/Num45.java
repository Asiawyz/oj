package day20241023;

/**
 * @author by asia
 * @Classname Num45
 * @Description TODO
 * @Date 2024/10/23 23:24
 */
public class Num45 {

    public static void main(String[] args) {

    }


    int ans;
    int[] nums;
    int n;

    public int jump(int[] nums) {
        n = nums.length;
        if (n < 2) {
            return 0;
        }
        this.nums = nums;
        ans = 0;
        dfs(0);
        return ans;
    }

    public void dfs(int start) {
        if (start + nums[start] >= n - 1) {
            ++ans;
            return;
        }
        int max = 0;
        int index = 0;
        for (int i = 1; i <= nums[start]; i++) {
            int j = start + i;
            if (max <= j + nums[j]) {
                max = j + nums[j];
                index = j;
            }
        }
        if (index > start) {
            ++ans;
            dfs(index);
        }
    }
}
