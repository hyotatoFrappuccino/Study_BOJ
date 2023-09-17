import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9095 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] dp = new int[num+1];
            dp[1] = 1;
            if (num > 1)
                dp[2] = 2;
            if (num > 2)
                dp[3] = 4;
            for (int j = 4; j <= num; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            sb.append(dp[num]).append("\n");
        }
        System.out.println(sb);
    }
}
