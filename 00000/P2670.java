import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2670 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] list = new double[N];
        double[] dp = new double[N];
        for (int i = 0; i < N; i++) {
            list[i] = Double.parseDouble(br.readLine());
        }
        dp[0] = list[0];
        for (int i = 1; i < N; i++) {
            double max = dp[i-1];
            double multi = 1;
            for (int j = i; j >= 0; j--) {
                multi *= list[j];
                max = Math.max(max, multi);
            }
            dp[i] = Math.max(dp[i-1], max);
        }
        System.out.printf("%.3f%n", dp[N-1]);
    }
}
