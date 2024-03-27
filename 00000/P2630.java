import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2630 {
    static int N;
    static int curN;
    static int white = 0;
    static int blue = 0;
    static int[][] matrix;
    static boolean[][] done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        done = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        curN = N;
        while (curN >= 1) {
            check();
            curN /= 2;
        }
        System.out.println(white + "\n" + blue);
    }

    public static void check() {
        for (int i = 0; i < N; i += curN) {
            for (int j = 0; j < N; j += curN) {
                int result = 0;
                for (int k = i; k < i + curN; k++) {
                    for (int l = j; l < j + curN; l++) {
                        result += matrix[k][l];
                    }
                }
                if (!done[i][j] && result == 0) {
                    white++;
                    for (int k = i; k < i + curN; k++) {
                        for (int l = j; l < j + curN; l++) {
                            done[k][l] = true;
                        }
                    }
                } else if (!done[i][j] && result == Math.pow(curN, 2)) {
                    blue++;
                    for (int k = i; k < i + curN; k++) {
                        for (int l = j; l < j + curN; l++) {
                            done[k][l] = true;
                        }
                    }
                }
            }
        }
    }
}
