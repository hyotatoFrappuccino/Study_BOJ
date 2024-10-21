import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] list = new int[2][N + 1];
            list[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // process
            int[][] dp = new int[N + 1][2];
            dp[0][0] = list[0][0];
            dp[0][1] = list[1][0];

            if (N > 1) {
                dp[1][0] = list[0][1] + list[1][0];
                dp[1][1] = list[0][0] + list[1][1];
            }

            for (int i = 2; i < N; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + list[0][i];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + list[1][i];
            }

            bw.append(String.valueOf(Math.max(dp[N - 1][0], dp[N - 1][1]))).append("\n");
        }
        
        // output
        bw.flush();

        br.close();
        bw.close();
    }
}