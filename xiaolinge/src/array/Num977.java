package array;

/**
 * @author by asia
 * @Classname Num977
 * @Description Num977
 * @Date 2024/9/25 16:40
 */
public class Num977 {

    public static void main(String[] args) {

    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int index = n - 1;
        int[] ans = new int[n];
        int left = 0, right = n - 1;
        while (left < right) {
            int x = nums[left] * nums[left];
            int y = nums[right] * nums[right];
            if (x > y) {
                ans[index--] = x;
                ++left;
            } else {
                ans[index--] = y;
                --right;
            }
        }
        ans[index] = nums[left] * nums[left];
        return ans;
    }



}
