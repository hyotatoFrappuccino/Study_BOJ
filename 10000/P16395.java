import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16395 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[][] dp = new long[31][31];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][1] = 1;
            for (int j = 2; j <= i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
            dp[i][i] = 1;
        }
        System.out.println(dp[n][k]);
    }
}
