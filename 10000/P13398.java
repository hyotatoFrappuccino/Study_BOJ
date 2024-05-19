import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P13398 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input

        int N = Integer.parseInt(br.readLine());
        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long max = list[0];
        int[][] dp = new int[N][2];

        // process

        dp[0][0] = list[0];
        dp[0][1] = list[0];

        for (int i = 1; i < N; i++) {
            // 제거하지 않은 경우 최대값
            // 합 or 자기 자신
            dp[i][0] = Math.max(dp[i - 1][0] + list[i], list[i]);
            // 제거한 경우 최대값
            // 자기 자신을 제거한 경우 or 제거안하고 계속 더하는경우
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + list[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        bw.append(String.valueOf(max));

        // output
        bw.flush();

        br.close();
        bw.close();
    }
}