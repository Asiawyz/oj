package hash;

import java.util.ArrayList;
import java.util.List;

public class Num1615 {

    public static void main(String[] args) {
//        int[][] a = {{1, 0}};
        int[][] a = {{13,2},{8,2},{1,2},{1,16},{11,14},{6,15},{7,2},{16,5},{2,6},{7,4},{7,11},{3,14},{5,0},{0,12},{8,6},{1,3},{7,9},{1,11},{4,17},{14,12},{3,16},{11,3},{4,16},{8,5},{17,9},{16,10},{16,0},{5,1},{10,5},{9,16},{2,12},{6,13},{10,8},{2,16},{5,4},{17,2},{15,17},{13,1},{5,3},{1,10},{10,13},{6,11},{10,2},{10,3},{9,10},{5,7},{15,4},{6,7},{0,14},{8,1},{7,13},{0,7},{12,16},{10,11},{6,12},{12,8},{7,14},{4,8},{8,11},{14,5},{0,11},{15,0},{13,9},{7,12},{15,14},{8,3},{2,5},{6,0},{13,16},{16,15},{8,0},{15,8},{12,17},{9,15},{3,7},{1,6},{15,13},{2,15},{3,2},{14,9},{15,10},{16,6},{5,6},{2,14},{4,2},{11,16},{13,4},{16,8},{3,0},{1,15},{10,12},{2,11},{8,17},{5,11},{12,13},{8,14},{12,11},{5,12},{11,9},{1,14},{17,16}};
        System.out.println(new Num1615().maximalNetworkRank2(18, a));
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] f = new int[n];
        boolean[][] b = new boolean[n][n];
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            f[x] += 1;
            f[y] += 1;
            b[x][y] = true;
            b[y][x] = true;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int zhi = f[i] + f[j];
                if (b[i][j]) {
                    zhi -= 1;
                }
                ans = Math.max(ans, zhi);
            }
        }
        return ans;
    }

    public int maximalNetworkRank2(int n, int[][] roads) {
        int[] f = new int[n];
        boolean[][] b = new boolean[n][n];
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            f[x] += 1;
            f[y] += 1;
            b[x][y] = true;
            b[y][x] = true;
        }
        int max = -1;
        int second = -2;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (f[i] > max) {
                l2 = new ArrayList<>(l1);
                second = max;
                max = f[i];
                l1.clear();;
                l1.add(i);
            } else if (f[i] == max) {
                l1.add(i);
            } else if (f[i] > second) {
                l2.clear();
                l2.add(i);
                second = f[i];
            } else if (f[i] == second) {
                l2.add(i);
            }
        }
        if (l1.size() == 1) {
            int i = l1.get(0);
            for (int x : l2) {
                if (!b[i][x]) {
                    return max + second;
                }
            }
            return max + second - 1;
        }
        int m = roads.length;
        // 起码得有 l1.size * (l1.size() - 1) / 2 条边，才能所有节点都互联
        if (l1.size() * (l1.size() - 1) / 2 > m) {
            return max * 2;
        }
        for (int x : l1) {
            for (int y : l1) {
                if (x != y && !b[x][y]) {
                    return max * 2;
                }
            }
        }
        return max * 2 - 1;

    }
}
