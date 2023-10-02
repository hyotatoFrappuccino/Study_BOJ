import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10211 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] list = new int[N];
            for (int j = 0; j < N; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[N];
            dp[0] = list[0];
            for (int j = 1; j < N; j++) {
                dp[j] = Math.max(dp[j-1] + list[j], list[j]);
            }
            Arrays.sort(dp);
            System.out.println(dp[N-1]);
        }
    }
}
