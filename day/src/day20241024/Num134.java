package day20241024;

/**
 * @author by asia
 * @Classname Num134
 * @Description TODO
 * @Date 2024/10/24 17:46
 */
public class Num134 {

    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total = 0;
        int start = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            count += diff;
            if (count < 0) {
                start = i + 1;
                count = 0;
            }
        }

        return total < 0 ? -1 : start;
    }
}
