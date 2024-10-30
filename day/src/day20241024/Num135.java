package day20241024;

/**
 * @author by asia
 * @Classname Num135
 * @Description TODO
 * @Date 2024/10/24 20:02
 */
public class Num135 {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 2};
        System.out.println(new Num135().candy(a));
    }

    int n;
    boolean[] flag;
    int[] ans;
    int[] nums;
    public int candy(int[] ratings) {
        n = ratings.length;
        flag = new boolean[n];
        ans = new int[n];
        nums = ratings;
        int index = findIndex();
        while (index != -1) {
            findAns(index);
            index = findIndex();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += ans[i];
        }
        return count;
    }

    public int findIndex() {
        int index = -1;
        int max = 100000000;
        for (int i = 0; i < n; i++) {
            if (flag[i]) {
                continue;
            }
            if (max > nums[i]) {
                index = i;
                max = nums[i];
            }
        }
        return index;
    }

    public void findAns(int index) {
        int count = 1;
        ans[index] = count;
        flag[index] = true;
        for (int i = index + 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                count = Math.max(count + 1, ans[i]);
                ans[i] = count;
                flag[i] = true;
            } else {
                break;
            }
        }
        count = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                count = Math.max(count + 1, ans[i]);
                flag[i] = true;
                ans[i] = count;
            } else {
                break;
            }
        }
    }


}
