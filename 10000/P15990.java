import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15990 {
    static final long divide = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[100_000 + 1][3 + 1];
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int j = 4; j <= 100_000; j++) {
            dp[j][1] = (dp[j - 1][2] + dp[j - 1][3]) % divide;
            dp[j][2] = (dp[j - 2][1] + dp[j - 2][3]) % divide;
            dp[j][3] = (dp[j - 3][1] + dp[j - 3][2]) % divide;
        }
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            bw.append(String.valueOf((dp[N][1] + dp[N][2] + dp[N][3]) % divide)).append("\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}