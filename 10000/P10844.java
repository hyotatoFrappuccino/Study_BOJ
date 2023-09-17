import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10844 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 9;
        if (N > 1)
            dp[2] = 17;
        int num = 8;
        for (int i = 3; i <= N; i++) {
            num += 24 + (i - 3) * 2;
            dp[i] = dp[i - 1] + num;
        }
        System.out.println(dp[N]);
    }
}
