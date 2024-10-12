import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P4883 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 1;
        String input = "";
        while (!(input = br.readLine()).equals("0")) {
            // input
            int N = Integer.parseInt(input);
            long[][] dp = new long[N][3];
            long[][] list = new long[N][3];
            for (int i = 0; i < N; i++) {
                list[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            }

            // process
            dp[1][0] = list[0][1] + list[1][0];
            dp[1][1] = Math.min(list[0][1], Math.min(list[0][1] + list[0][2], dp[1][0])) + list[1][1];
            dp[1][2] = Math.min(list[0][1], Math.min(list[0][1] + list[0][2], dp[1][1])) + list[1][2];
            for (int i = 2; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + list[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], Math.min(dp[i][0], dp[i - 1][2]))) + list[i][1];
                dp[i][2] = Math.min(dp[i - 1][1], Math.min(dp[i][1], dp[i - 1][2])) + list[i][2];
            }

            bw.append(String.valueOf(idx++)).append(". ").append(String.valueOf(dp[N - 1][1])).append("\n");
        }

        // output
        bw.flush();

        br.close();
        bw.close();
    }
}