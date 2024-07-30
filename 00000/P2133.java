import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2133 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int N = Integer.parseInt(br.readLine());

        // process
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int i = 2; i <= N; i += 2) {
            dp[i] = dp [i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }
        bw.append(String.valueOf(dp[N]));

        // output
        bw.flush();

        br.close();
        bw.close();
    }
}
