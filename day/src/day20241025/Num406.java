package day20241025;

import day20241016.Num40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num406
 * @Description TODO
 * @Date 2024/10/25 21:18
 */
public class Num406 {

    public static void main(String[] args) {
        int[][] a = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = new Num406().reconstructQueue(a);
        for (int[] aa : ints) {
            System.out.println(aa[0] + " " + aa[1]);
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        List<int[]> ans = new LinkedList<>();
        for (int[] a : people) {
            ans.add(a[1], a);
        }

        return ans.toArray(new int[people.length][]);
    }
}
