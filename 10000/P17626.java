import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 1;
        int min;
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                // min을 이용하여 최소항의 개수를 구함
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min +1;
        }
        System.out.println(dp[N]);
    }
}
