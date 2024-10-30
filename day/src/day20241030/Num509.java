package day20241030;

/**
 * @author by asia
 * @Classname Num504
 * @Description TODO
 * @Date 2024/10/30 10:54
 */
public class Num509 {

    public static void main(String[] args) {
        System.out.println(new Num509().fib(3));
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int x = 0, y = 1;
        for (int i = 1; i < n; i++) {
            int z = x + y;
            x = y;
            y = z;
        }
        return y;
    }

}
