import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14494 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n+1][m+1];
        dp[1][1] = 1;
        for (int i = 2; i <= m; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i][1] = 1;
            for (int j = 2; j <= m ; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j] + dp[i-1][j-1]) % 1000000007;
            }
        }
        System.out.println(dp[n][m]);
    }
}
