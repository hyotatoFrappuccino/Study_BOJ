import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P25214 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("0 ");
        int[] list = new int[N+1];
        int[] dp = new int[N+1];
        dp[1] = 0;
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int min = list[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i-1], list[i] - min);
            min = Math.min(min, list[i]);
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }
}
