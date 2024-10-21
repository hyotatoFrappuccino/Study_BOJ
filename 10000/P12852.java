import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P12852 {
    static int N;
    static int minLen;
    static int[] dp;
    static int[] list;
    static StringBuilder output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        dp = new int[N + 1];
        list = new int[N + 1];
        minLen = Integer.MAX_VALUE;
        output = new StringBuilder();
    }

    static String process() {
        list[0] = N;
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        recur(N);

        return output.toString();
    }

    private static void recur(int N) {
        if (N == 1) {
            if (dp[1] < minLen) {
                minLen = dp[1];
                output = new StringBuilder();
                output.append(dp[1]).append("\n");
                for (int i = 0; i < dp[1] + 1; i++) {
                    output.append(list[i]).append(" ");
                }
            }
            return;
        }

        if (N % 3 == 0) {
            if (dp[N] + 1 < dp[N / 3]) {
                dp[N / 3] = dp[N] + 1;
                list[dp[N] + 1] = N / 3;
                recur(N / 3);
            }
        }

        if (N % 2 == 0) {
            if (dp[N] + 1 < dp[N / 2]) {
                dp[N / 2] = dp[N] + 1;
                list[dp[N] + 1] = N / 2;
                recur(N / 2);
            }
        }

        if (dp[N] + 1 < dp[N - 1]) {
            dp[N - 1] = dp[N] + 1;
            list[dp[N] + 1] = N - 1;
            recur(N - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.println(process());
    }

    private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);
        return linesArray;
    }
}