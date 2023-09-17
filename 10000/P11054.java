import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11054 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int[] dp = new int[N];
        //noinspection DuplicatedCode
        int[] dp2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (list[j] < list[i] && dp2[i] < dp2[j] + 1)
                    dp2[i] = dp2[j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i] + dp2[i] - 1);
        }
        System.out.println(max);
    }
}
