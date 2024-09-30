import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P4097 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        String input = "";
        // 백준 제출용
        //while ((input = br.readLine()) != null) {
        // 인텔리제이용
        while ((input = br.readLine()) != null & !input.isEmpty()) {
            int N = Integer.parseInt(input);
            if (N == 0) break;

            int[] arr = new int[N];
            int[] dp = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int len = 1;
            int max = Integer.MIN_VALUE;
            dp[0] = arr[0];

            for (int i = 1; i < N; i++) {
                if (arr[i] > dp[i - 1] + arr[i]) {
                    dp[i] = arr[i];
                    len = 1;
                } else {
                    len++;
                    dp[i] = dp[i - 1] + arr[i];
                }

                max = Math.max(max, dp[i]);
            }

            bw.write(String.valueOf(max));
            bw.write("\n");
        }

        // process


        // output
        bw.flush();

        br.close();
        bw.close();
    }
}