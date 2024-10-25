package day20241023;

/**
 * @author by asia
 * @Classname Num55
 * @Description TODO
 * @Date 2024/10/23 23:09
 */
public class Num55 {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 0, 4};
        System.out.println(new Num55().canJump(a));
    }

    boolean flag;
    int[] nums;
    int n;

    public boolean canJump(int[] nums) {
        n = nums.length;
        this.nums = nums;
        flag = false;
        dfs(0);
        return flag;
    }

    public void dfs(int start) {
        if (start + nums[start] >= n - 1) {
            flag = true;
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
            dfs(index);
        }
    }
}
