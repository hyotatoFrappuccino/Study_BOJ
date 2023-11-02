import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P25706 {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("DuplicatedCode")
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        dp[N-1] = 1;
        for (int i = N-2; i >= 0; i--) {
            if (list[i] > 0) {
                // 범위가 넘어가는 경우
                if (i + list[i] + 1 >= N)
                    dp[i] = 1;
                // 범위 안에 드는 경우
                else
                    dp[i] = dp[i + list[i] + 1] + 1;
            }
            else
                dp[i] = dp[i+1] + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }
}