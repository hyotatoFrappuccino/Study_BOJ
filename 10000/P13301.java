import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P13301 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[81];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        if (N == 1)
            System.out.println("4");
        else if (N == 2)
            System.out.println("6");
        else if (N == 3)
            System.out.println("10");
        else
            System.out.println(dp[N] * 3 + dp[N-1] * 2 + dp[N-2] * 2 + dp[N-3]);
    }
}
