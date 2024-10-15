package day20240926;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by asia
 * @Classname Num202
 * @Description TODO
 * @Date 2024/9/26 23:47
 */
public class Num202 {

    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            n = calculate(n);
            if (set.contains(n)) {
                return false;
            }
        }
        return true;
    }

    public int calculate(int x) {
        int count = 0;
        while (x >= 10) {
            int y = x % 10;
            x /= 10;
            count += y * y;
        }
        return count + x * x;
    }
}
