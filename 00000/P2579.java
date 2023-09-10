import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2579 {
    public static void main(String[] args) throws Exception {
        //noinspection DuplicatedCode
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N+1];
        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        if (N < 2) {
            System.out.println(list[1]);
        }
        else {
            dp[1] = list[1];
            dp[2] = list[1] + list[2];
            for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(dp[i - 3] + list[i - 1] + list[i], dp[i - 2] + list[i]);
            }
            System.out.println(dp[N]);
        }
    }
}
