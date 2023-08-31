import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list[i] = num;
        }
        int[] dp = new int[N];
        dp[0] = list[0];
        int max = list[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + list[i], list[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
