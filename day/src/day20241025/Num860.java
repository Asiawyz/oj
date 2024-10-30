package day20241025;

/**
 * @author by asia
 * @Classname Num860
 * @Description TODO
 * @Date 2024/10/25 21:06
 */
public class Num860 {

    public static void main(String[] args) {

    }

    public boolean lemonadeChange(int[] bills) {
        int x = 0;
        int y = 0;
        for (int money : bills) {
            if (money == 5) {
                ++x;
                continue;
            }
            if (money == 10) {
                ++y;
                if (x < 1) {
                    return false;
                }
                --x;
                continue;
            }
            --x;
            if (y > 0) {
                --y;
            } else {
                x -= 2;
            }
            if (x < 0) {
                return false;
            }
        }
        return true;
    }
}
