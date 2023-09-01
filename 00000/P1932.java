import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = list[0][0];
        int max = list[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                int num = 0;
                if (j - 1 >= 0) num = dp[i-1][j-1];
                dp[i][j] = Math.max(num + list[i][j], dp[i-1][j] + list[i][j]);
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}
