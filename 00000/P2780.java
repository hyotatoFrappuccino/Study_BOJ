import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2780 {
    static int T;
    static int[] N;
    static final int maxN = 1_000;
    static final int MOD = 1_234_567;
    static StringBuilder output;

    static void input(String[] lines) {
        T = Integer.parseInt(lines[0]);

        N = new int[T];
        for (int i = 0; i < T; i++) {
            N[i] = Integer.parseInt(lines[i + 1]);
        }

        output = new StringBuilder();
    }

    static String process() {
        int[][] dp = new int[maxN][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < maxN; i++) {
            dp[i][0] = dp[i - 1][7] % MOD;
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][4]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5]) % MOD;
            dp[i][3] = (dp[i - 1][2] + dp[i - 1][6]) % MOD;
            dp[i][4] = (dp[i - 1][1] + dp[i - 1][5] + dp[i - 1][7]) % MOD;
            dp[i][5] = (dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][6] + dp[i - 1][8]) % MOD;
            dp[i][6] = (dp[i - 1][3] + dp[i - 1][5] + dp[i - 1][9]) % MOD;
            dp[i][7] = (dp[i - 1][4] + dp[i - 1][8] + dp[i - 1][0]) % MOD;
            dp[i][8] = (dp[i - 1][5] + dp[i - 1][7] + dp[i - 1][9]) % MOD;
            dp[i][9] = (dp[i - 1][6] + dp[i - 1][8]) % MOD;
        }

        for (int n : N) {
            int sum = 0;
            for (int ints : dp[n - 1]) {
                sum = (sum + ints) % MOD;
            }
            output.append(sum).append("\n");
        }
        return output.toString();
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