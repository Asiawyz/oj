package array;

/**
 * @author by asia
 * @Classname Num35
 * @Description Num35
 * @Date 2024/9/26 13:35
 */
public class Num35 {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        System.out.println(new Num35().searchInsert(a,7));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
