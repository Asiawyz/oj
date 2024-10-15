package array;

public class Num200 {

    public static void main(String[] args) {
        char[][] a = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

    }

    public int numIslands(char[][] grid) {
        int[] a = {1, -1, 0, 0};
        int[] b = {0, 0, 1, -1};
        int index = 2, n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                ++ans;
                find(i, j, grid);
            }
        }
        return ans;
    }

    public void find(int left, int right, char[][] grid) {
        if (left < 0 || left >= grid.length || right < 0 || right >= grid[0].length) {
            return;
        }
        if (grid[left][right] == '0') {
            return;
        }
        grid[left][right] = '0';
        find(left + 1, right, grid);
        find(left - 1, right, grid);
        find(left, right + 1, grid);
        find(left, right - 1, grid);
    }
}
