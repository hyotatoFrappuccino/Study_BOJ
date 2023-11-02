import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P17212 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+8];
        dp[0] = 0;
        dp[1] = dp[2] = dp[5] = dp[7] = 1;
        dp[3] = dp[4] = dp[6] = 2;
        for (int i = 8; i <= N; i++) {
            dp[i] = Math.min(dp[i-7] + 1, Math.min(dp[i-5] + 1, Math.min(dp[i-2] + 1, dp[i-1] + 1)));
        }
        System.out.println(dp[N]);
    }
}
