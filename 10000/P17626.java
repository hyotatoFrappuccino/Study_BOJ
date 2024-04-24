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
        // DP 를 채우기 위한 반복
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;
            // 숫자가 5인 경우, 루트5=2 이고, 2^2 + 1^2 으로 나타낼 수 있으므로 포함된 2^2을 구하기 위해 아래 FOR문을 이용
            // min(dp[5-1], dp[5-4])
            // min(1 (2^2경우), 1(1^2) 경우)
            // 즉 제곱수인 것들을 빼어 최소항의 개수를 구하는 것임

            // 숫자가 13인 경우, 루트13=3 이고, j는 1~3 반복
            // min(dp[13-1], dp[13-4], "dp[13-9]")
            // 1, 4, 9가 최소 제곱수로 이루어져 있으면서 최대값이므로 빼준것임.
            // min(dp[12], dp[9], "dp[4]")
            // min(3, 1, 1)
            // 3^2인 dp[9]에 2^2인 dp[4] 추가 (위의 "" 봐보기)
            for (int j = 1; j <= Math.sqrt(i); j++) {
                // min을 이용하여 최소항의 개수를 구함
                min = Math.min(min, dp[i - j * j]);
            }
            // 최소항의 개수에 현재항을 추가
            dp[i] = min +1;
        }
        System.out.println(dp[N]);
    }
}
