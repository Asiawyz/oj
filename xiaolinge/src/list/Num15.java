package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Num15().threeSum(nums);
        for (List<Integer> list : lists) {
            StringBuilder s = new StringBuilder();
            for (int x : list) {
                s.append(x).append(" ");
            }
            System.out.println(s);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 3) {
            return ans;
        }
        for (int i = 0; i < n - 2;) {
            for (int j = i + 1, k = n - 1; j < k;) {
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                int count = nums[i] + nums[j] + nums[k];
                if (count == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    ++j;
                    while (j < n - 1 && nums[j] == nums[j - 1]) {
                        ++j;
                    }
                } else if (count > 0) {
                    --k;
                    while (k > j && nums[k] == nums[k + 1]) {
                        --k;
                    }
                } else {
                    ++j;
                    while (j < n - 1 && nums[j] == nums[j - 1]) {
                        ++j;
                    }
                }
            }
            ++i;
            while (i < n && nums[i] == nums[i - 1]) {
                ++i;
            }
        }
        return ans;
    }
}
