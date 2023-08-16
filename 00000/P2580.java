import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2580 {
    static int[][] matrix = new int[9][9];
    static boolean[][] visited = new boolean[9][9];
    public static void main(String[] args) throws Exception {
        input();
        sudoku(0, 0);
    }

    public static void sudoku(int row, int col) {
        if (row == 9 && col == 0) {
            print();
            System.exit(0);
            return;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if(!visited[i][j]) {
                            matrix[i][j] = k;
                            visited[i][j] = true;
                            if (possibility()) {
                                int r = i;
                                int c = j + 1;
                                if (c > 8) {
                                    r = i + 1;
                                    c = 0;
                                }
                                sudoku(r, c);
                            }
                            visited[i][j] = false;
                        }
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    public static boolean possibility() {
        for (int i = 0; i < 9; i++) {
            int[] check1 = new int[9+1];
            int[] check2 = new int[9+1];
            for (int j = 0; j < 9; j++) {
                check1[matrix[i][j]]++;
                check2[matrix[j][i]]++;
            }
            boolean poss = true;
            for (int j = 1; j <= 9; j++) {
                if (check1[j] > 1 || check2[j] > 1) {
                    poss = false;
                    break;
                }
            }
            if (!poss) return false;
        }

        // 3x3 검사
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                int[] check = new int[9+1];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        check[matrix[i+k][j+l]]++;
                    }
                }
                boolean poss = true;
                for (int k = 1; k <= 9; k++) {
                    if (check[k] > 1) {
                        poss = false;
                        break;
                    }
                }
                if (!poss) return false;
            }
        }
        return true;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
