import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2580 {
    static int[][] matrix = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        sudoku(0, 0);
    }

    public static void sudoku(int row, int col) {
        if (col > 8) {
            sudoku(row + 1, 0);
            return;
        }
        if (row > 8) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(matrix[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (matrix[row][col] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (possibility(row, col, k)) {
                    matrix[row][col] = k;
                    sudoku(row, col + 1);
                }
            }
            matrix[row][col] = 0;
            return;
        }
        sudoku(row, col + 1);
    }

    public static boolean possibility(int row, int col, int val) {
        // 가로세로 검사
        for (int i = 0; i < 9; i++) {
            if (matrix[row][i] == val || matrix[i][col] == val)
                return false;
        }

        int rr = (row / 3) * 3;
        int cc = (col / 3) * 3;
        for (int i = rr; i < rr + 3; i++) {
            for (int j = cc; j < cc + 3; j++) {
                if (matrix[i][j] == val)
                    return false;
            }
        }
        return true;
    }
}
