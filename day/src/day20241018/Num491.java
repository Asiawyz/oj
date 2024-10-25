package day20241018;

import java.util.*;

/**
 * @author by asia
 * @Classname Num491
 * @Description TODO
 * @Date 2024/10/18 17:57
 */
public class Num491 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        new Num491().findSubsequences(a);
    }

    List<Integer> tmp;
    List<List<Integer>> ans;
    int n;
    int[] nums;

    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new LinkedList<>();
        tmp = new ArrayList<>(nums.length);
        n = nums.length;
        this.nums = nums;
        dfs(0, -1000);
        return ans;
    }

    public void dfs(int index, int last) {
            if (tmp.size() > 1) {
                ans.add(new ArrayList<>(tmp));
                for (int x : tmp) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < n; i++) {
            if (nums[i] >= last && !set.contains(nums[i])) {
                set.add(nums[i]);
                tmp.add(nums[i]);
                dfs(i + 1, nums[i]);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}

