package array;

/**
 * @author by asia
 * @Classname Num27
 * @Description Num27
 * @Date 2024/9/25 15:31
 */
public class Num27 {

    public static void main(String[] args) {
//        int[] a = {0,1,2,2,3,0,4,2};
        int[] a = {2,2,3};
        int x = 2;
        System.out.println(new Num27().removeElement2(a, x));
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        int ans = nums.length;
        for (int x : nums) {
            if (x != val) {
                nums[index++] = x;
            } else {
                --ans;
            }
        }
        return ans;
    }

    public int removeElement2(int[] nums, int val) {
        int length = nums.length, ans = length;
        int left = 0, right = length - 1;
        while (left < right) {
            while (left < right && nums[left] != val) {
                ++left;
            }
            while (right >= left && nums[right] == val) {
                --right;
                --ans;
            }
            if (right < left) {
                return ans;
            }
            if (nums[left] == val) {
                --ans;
                nums[left++] = nums[right--];
            }
        }
        if (right == left && nums[left] == val) {
            --ans;
        }
        return ans;
    }


}
