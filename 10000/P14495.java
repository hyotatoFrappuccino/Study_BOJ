import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14495 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+3];
        dp[1] = dp[2] = dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-3];
        }
        System.out.println(dp[N]);
    }
}
