import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15724 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[N + 1][M + 1];
        dp[1][1] = matrix[0][0];
        for (int i = 1; i <= N; i++) {
            dp[i][1] = dp[i - 1][1] + matrix[i - 1][0];
        }

        for (int i = 1; i <= M; i++) {
            dp[1][i] = dp[1][i - 1] + matrix[0][i - 1];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum1 = dp[x2][y2];
            int sum2 = dp[x1 - 1][y1 - 1];
            int sum3 = dp[x2][y1 - 1];
            int sum4 = dp[x1 - 1][y2];

            int sum = sum1 + sum2 - sum3 - sum4;
            bw.append(String.valueOf(sum)).append("\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}