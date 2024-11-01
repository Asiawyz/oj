package day20241031;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author by asia
 * @Classname Num416
 * @Description TODO
 * @Date 2024/10/31 18:56
 */
public class Num416 {

    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int count = sum / 2;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (x == count) {
                return true;
            }
            Set<Integer> tmp = new HashSet<>();
            tmp.add(x);
            for (int y : set) {
                if (x + y == count) {
                    return true;
                }
                tmp.add(x + y);
            }
            set.addAll(tmp);
        }
        return false;
    }
}
