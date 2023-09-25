import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P25644 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] list = new long[N];
        long[] dp = new long[N];
        long[] min = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Long.parseLong(st.nextToken());
        }
        min[0] = list[0];
        for (int i = 1; i < N; i++) {
            min[i] = Math.min(min[i-1], list[i]);
            dp[i] = Math.max(dp[i-1], list[i] - min[i]);
        }
        System.out.println(dp[N-1]);
    }
}
