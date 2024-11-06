package day20241104;

import java.util.Arrays;

/**
 * @author by asia
 * @Classname Num377
 * @Description TODO
 * @Date 2024/11/4 22:04
 */
public class Num377 {

    public static void main(String[] args) {

    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int x : nums) {
                if (i < x) {
                    break;
                }
                f[i] += f[i - x];
            }
        }
        return f[target];
    }
}
