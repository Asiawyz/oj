package day20241016;

import java.util.*;

/**
 * @author by asia
 * @Classname Num40
 * @Description TODO
 * @Date 2024/10/16 23:18
 */
public class Num40 {

    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        new Num40().combinationSum2(a, 8);
    }

    List<List<Integer>> ans;
    List<Integer> tmp;
    int[] nums;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new LinkedList<>();
        tmp = new ArrayList<>();
        nums = candidates;
        this.target = target;
        Arrays.sort(nums);
        dfs(0, target);
        return ans;
    }

    public void dfs(int index, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            for (int x : tmp) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (target < nums[i]) {
                break;
            }
            tmp.add(nums[i]);
            dfs(i + 1, target - nums[i]);
            tmp.remove(tmp.size() - 1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
    }
}
