package array;

public class Num33 {

    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(new Num33().search(nums, target));
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] >= nums[left]) {
            if (target < nums[left] || target > nums[mid]) {
                return search(nums, target, mid + 1, right);
            }
            return search(nums, target, left, mid - 1);
        } else {
            if (nums[mid] > target) {
                return search(nums, target, left, mid - 1);
            }
            return Math.max(search(nums, target, left, mid - 1), search(nums, target, mid + 1, right));
        }
    }
}
