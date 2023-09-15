import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P15312 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        int[] dp = new int[A.length + B.length];
        for (int i = 0; i < A.length; i++) {
            dp[i*2] = list[(int)A[i] - 65];
            dp[i*2 + 1] = list[(int)B[i] - 65];
        }
        for (int i = 0; i < dp.length - 2; i++) {
            for (int j = 0; j < dp.length - 1; j++) {
                dp[j] = (dp[j] + dp[j+1]) % 10;
            }
        }
        System.out.println(dp[0] + String.valueOf(dp[1]));
    }
}
