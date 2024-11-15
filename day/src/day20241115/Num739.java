package day20241115;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author by asia
 * @Classname Num739
 * @Description TODO
 * @Date 2024/11/15 13:48
 */
public class Num739 {

    public static void main(String[] args) {
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new Num739().dailyTemperatures(a)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty()) {
                int x = deque.peekLast();
                int y = temperatures[x];
                if (temperatures[i] > y) {
                    ans[x] = i - x;
                    deque.removeLast();
                } else {
                    break;
                }
            }
            deque.addLast(i);
        }
        return ans;
    }

}
