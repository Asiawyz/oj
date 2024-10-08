package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num18 {

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> lists = new Num18().fourSum(nums, target);
        for (List<Integer> list : lists) {
            StringBuilder s = new StringBuilder();
            for (int x : list) {
                s.append(x).append(" ");
            }
            System.out.println(s);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3;) {
            for (int j = i + 1; j < n - 2;) {
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long count = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];
                    if (count == target) {
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        ++left;
                        while (left < right && nums[left] == nums[left - 1]) {
                            ++left;
                        }
                        --right;
                        while (left < right && nums[right] == nums[right + 1]) {
                            --right;
                        }
                    } else if (count > target) {
                        --right;
                        while (left < right && nums[right] == nums[right + 1]) {
                            --right;
                        }
                    } else {
                        ++left;
                        while (left < right && nums[left] == nums[left - 1]) {
                            ++left;
                        }
                    }
                }
                ++j;
                while (j < n - 2 && nums[j] == nums[j - 1]) {
                    ++j;
                }
            }
            ++i;
            while (i < n - 3 && nums[i] == nums[i - 1]) {
                ++i;
            }
        }
        return ans;
    }
}
