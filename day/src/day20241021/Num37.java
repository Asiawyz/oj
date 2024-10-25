package day20241021;

/**
 * @author by asia
 * @Classname Num37
 * @Description TODO
 * @Date 2024/10/21 21:42
 */
public class Num37 {

    public static void main(String[] args) {

    }

    int n = 3;
    int N = n * n;
    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];
    char[][] board;
    boolean flag = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.'){
                    int d = Character.getNumericValue(num);
                    setNumber(d,i,j);
                }
            }
        }
        find(0,0);
    }

    private void removeNumber(int i, int x, int y) {
        int idx = (x / n ) * n + y / n;
        rows[x][i]--;
        columns[y][i]--;
        boxes[idx][i]--;
        board[x][y] = '.';
    }

    private void setNextNumber(int x, int y) {
        if ((x == N - 1) && (y == N - 1)){
            flag = true;
        }
        else{
            if (y == N - 1){
                find(x + 1,0);
            }
            else {
                find(x, y + 1);
            }
        }
    }

    private boolean couldSet(int i, int x, int y) {
        int index = (x / n) * n + y / n;
        return rows[x][i] + columns[y][i] + boxes[index][i] == 0;
    }

    private void setNumber(int d, int x, int y) {
        int index = (x / n) * n + y / n;
        rows[x][d]++;
        columns[y][d]++;
        boxes[index][d]++;
        board[x][y] = (char) (d + '0');
    }

    private void find(int x, int y) {
        if (board[x][y] == '.'){
            for (int i = 1; i < 10 ; i++) {
                if (couldSet(i,x,y)){
                    setNumber(i,x,y);
                    setNextNumber(x,y);
                    if (!flag){
                        removeNumber(i,x,y);
                    } else {
                        return;
                    }
                }
            }
        }
        else {
            setNextNumber(x,y);
        }
    }
}
