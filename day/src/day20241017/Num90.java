package day20241017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num90
 * @Description TODO
 * @Date 2024/10/17 17:42
 */
public class Num90 {

    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        new Num90().subsetsWithDup(a);
    }

    List<Integer> tmp;
    List<List<Integer>> ans;
    int n;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new LinkedList<>();
        tmp = new ArrayList<>(nums.length);
        n = nums.length;
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0);
        return ans;
    }


    public void dfs(int index) {
        if (index == n) {
            ans.add(new ArrayList<>(tmp));
            for (int x : tmp) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        tmp.add(nums[index]);
        dfs(index + 1);
        tmp.remove(tmp.size() - 1);
        while (index + 1 < n && nums[index] == nums[index + 1]) {
            ++index;
        }
        dfs(index + 1);
    }

}
