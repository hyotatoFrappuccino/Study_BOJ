import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15489 {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("DuplicatedCode")
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[31][31];
        for (int i = 1; i <= 30; i++) {
            dp[i][1] = dp[i][i] = 1;
        }
        for (int i = 3; i <= R + W; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int sum = 0;
        int cc = 0;
        for (int i = R; i < R + W; i++) {
            for (int j = C; j <= (C + cc); j++) {
                sum += dp[i][j];
            }
            cc++;
        }
        System.out.println(sum);
    }
}
