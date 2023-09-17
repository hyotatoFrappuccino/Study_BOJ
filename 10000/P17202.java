import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17202 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] A = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[16];
        for (int i = 0; i < 8; i++) {
            dp[i*2] = A[i];
            dp[i*2+1] = B[i];
        }
        for (int j = 0; j < 14; j++) {
            for (int i = 0; i < 15; i++) {
                dp[i] = (dp[i] + dp[i+1]) % 10;
            }
        }
        System.out.println(dp[0] + String.valueOf(dp[1]));
    }
}
