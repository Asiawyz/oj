package array;

import java.util.Arrays;

/**
 * @author by asia
 * @Classname Num2389
 * @Description Num2389
 * @Date 2024/9/26 17:16
 */
public class Num2389 {

    public static void main(String[] args) {

    }

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        int n = nums.length, m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int count = sum;
            int index = n - 1;
            while (count > queries[i] && index >= 0) {
                count -= nums[index--];
            }
            ans[i] = index + 1;
        }
        return ans;
    }

}
