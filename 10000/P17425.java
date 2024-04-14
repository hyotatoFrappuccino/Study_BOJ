import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P17425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] dp = new long[1_000_000+1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < dp.length; i++) {
            dp[i] += dp[i - 1];
            for (int j = 1; i * j < dp.length; j++) {
                dp[i * j] += i;
            }
        }

        int testcase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testcase; t++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
