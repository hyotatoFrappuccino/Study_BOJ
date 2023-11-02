import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P13699 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[N+1];
        dp[0] = BigInteger.ONE;
        for (int i = 1; i <= N; i++) {
            BigInteger sum = BigInteger.ZERO;
            for (int j = 0; j < i / 2; j++) {
                sum = sum.add((dp[j].multiply(dp[i-j-1])).multiply(BigInteger.TWO));
            }
            if ((i & 1) == 1)
                sum = sum.add(dp[i/2].multiply(dp[i/2]));
            dp[i] = sum;
        }
        System.out.println(dp[N]);
    }
}
