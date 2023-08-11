import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P9663 {
    static boolean[][] queen;
    static boolean[][] visit;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
        N = 8;
        queen = new boolean[N][N];
        visit = new boolean[N][N];
        nqueen(0);
        System.out.println(count);
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(queen[i]));
        }
    }

    public static void nqueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    boolean run = true;
                    for (int k = 0; k < N; k++) {
                        if ((k != j && queen[i][k])
                         || (k != i && queen[k][j])
                         || (i + k < N && i + k != i && j + k != j && j + k < N && queen[i + k][j + k])
                         || (i - k < N && i - k >= 0 && i - k != i && j - k != j && j - k >= 0 && queen[i - k][j - k])
                        ) {
                            run = false;
                            break;
                        }
                    }
                    if (run) {
                        visit[i][j] = true;
                        queen[i][j] = true;
                        nqueen(depth + 1);
                        visit[i][j] = false;
                    }
                }
            }
        }
    }
}
