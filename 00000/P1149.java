import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][N];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.arraycopy(list[0], 0, dp[0], 0, 3);
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1] + list[i][0], dp[i-1][2] + list[i][0]);
            dp[i][1] = Math.min(dp[i-1][0] + list[i][1], dp[i-1][2] + list[i][1]);
            dp[i][2] = Math.min(dp[i-1][0] + list[i][2], dp[i-1][1] + list[i][2]);
        }
        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
}
