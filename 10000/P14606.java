import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14606 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 3;
        for (int i = 4; i <= N; i++) {
            if ((i & 1) == 0)
                dp[i] += Math.pow((double) i / 2, 2) + dp[i/2] * 2;
            else
                dp[i] += (i / 2 + 1) * (i / 2) + dp[i / 2 + 1] + dp[i / 2];
        }
        System.out.println(dp[N]);
    }
}
