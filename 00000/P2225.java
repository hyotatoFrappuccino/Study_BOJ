import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2225 {
    static int N;
    static int K;
    static long divide = 1_000_000_000;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static String process() {
        long[][] dp = new long[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1;
        }
        for (int i = 0; i <= K; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                long sum = 0;
                for (int k = 0; k <= i; k++) {
                    sum = (sum + dp[k][j - 1]) % divide;
                }
                dp[i][j] = sum;
            }
        }
        return String.valueOf(dp[N][K] % divide);
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