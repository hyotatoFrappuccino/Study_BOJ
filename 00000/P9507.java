import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9507 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        long[] dp = new long[68];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 67; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4];
        }
        for (int i = 0; i < testcase; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
