package array;

/**
 * @author by asia
 * @Classname Num59
 * @Description Num59
 * @Date 2024/9/26 13:01
 */
public class Num59 {

    public static void main(String[] args) {

    }

    public int[][] generateMatrix(int n) {
        int[] a = {0, 1, 0, -1};
        int[] b = {1, 0, -1, 0};
        int direction = 0;
        int number = 1, max = n * n;
        int[][] ans = new int[n][n];
        int i = 0, j = 0;
        while (number <= max) {
            ans[i][j] = number++;
            if (i + a[direction] < 0 || i + a[direction] == n) {
                direction = (direction + 1) % 4;
            } else if (j + b[direction] < 0 || j + b[direction] == n){
                direction = (direction + 1) % 4;
            } else if (ans[i + a[direction]][j + b[direction]] > 0) {
                direction = (direction + 1) % 4;
            }
            i += a[direction];
            j += b[direction];
        }
        return ans;
    }

}
