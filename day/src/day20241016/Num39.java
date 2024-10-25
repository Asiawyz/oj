package day20241016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num38
 * @Description TODO
 * @Date 2024/10/16 22:45
 */
public class Num39 {

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        new Num39().combinationSum(a, 7);
    }


    List<List<Integer>> ans;
    List<Integer> tmp;
    int[] nums;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            dfs(i, target - nums[i]);
            tmp.remove(tmp.size() - 1);
        }
    }
}
