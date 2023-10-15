import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P17520 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+3];
        dp[1] = 2;
        for (int i = 2; i <= N; i++) {
            if ((i & 1) == 0)
                dp[i] = dp[i-1];
            else
                dp[i] = (dp[i-1] + dp[i-2]) % 16769023;
        }
        System.out.println(dp[N]);
    }
}
