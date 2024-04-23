import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P3085 {
    private static char[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int N = Integer.parseInt(br.readLine());
        matrix = new char[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        // process
        int result = 0;
//         좌우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
//                matrix[i][j] 와 matrix[i][j+1] 교환
                if (matrix[i][j] != matrix[i][j + 1]) {
                    changeCandy(i, j, i, j + 1);
                    result = Math.max(result, getMaxCandy());
                    changeCandy(i, j, i, j + 1);
                }
            }
        }

        // 상하
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
//                matrix[i][j] 와 matrix[i+1][j] 교환
                if (matrix[i][j] != matrix[i + 1][j]) {
                    changeCandy(i, j, i + 1, j);
                    result = Math.max(result, getMaxCandy());
                    changeCandy(i, j, i + 1, j);
                }
            }
        }


        // output
        System.out.println(result);

        br.close();
        bw.close();
    }

    /**
     * 값 교환
     * @param i  첫번째 값의 row
     * @param j  첫번재 값의 col
     * @param ii 두번째 값의 row
     * @param jj 두번째 값의 col
     */
    private static void changeCandy(int i, int j, int ii, int jj) {
        char tmp = matrix[ii][jj];
        matrix[ii][jj] = matrix[i][j];
        matrix[i][j] = tmp;
    }

    /**
     * 먹을 수 있는 사탕의 최대 개수 반환
     * @return 먹을 수 있는 사탕의 최대 개수
     */
    private static int getMaxCandy() {
        int len = matrix.length;
        int max = 0;

        // n번재 줄까지
        for (int i = 0; i < len; i++) {
            // i번째 줄에서 j와 j+1 비교
            char rowC = matrix[i][0];
            char colC = matrix[0][i];
            int rowStraightLen = 1;
            int colStraightLen = 1;

            for (int j = 1; j < len; j++) {
                // 가로 탐색
                if (matrix[i][j] == rowC) {
                    rowStraightLen++;
                    max = Math.max(max, rowStraightLen);
                } else {
                    rowC = matrix[i][j];
                    rowStraightLen = 1;
                }

                // 세로 탐색
                if (matrix[j][i] == colC) {
                    colStraightLen++;
                    max = Math.max(max, colStraightLen);
                } else {
                    colC = matrix[j][i];
                    colStraightLen = 1;
                }
            }
            max = Math.max(max, Math.max(colStraightLen, rowStraightLen));
        }

        return max;
    }
}
