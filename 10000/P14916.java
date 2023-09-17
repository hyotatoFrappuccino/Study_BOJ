import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        dp[0] = -1;
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;
        for (int i = 6; i <= N; i++) {
            if (dp[i-2] == -1 && dp[i-5] != -1)
                dp[i] = dp[i-5] + 1;
            else if (dp[i-2] != -1 && dp[i-5] == -1)
                dp[i] = dp[i-2] + 1;
            else if (dp[i-2] != -1 && dp[i-5] != -1)
                dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
            else
                dp[i] = -1;
        }
        System.out.println(dp[N]);
    }
}
