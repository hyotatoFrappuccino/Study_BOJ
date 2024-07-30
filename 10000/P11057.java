import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P11057 {
    static int N;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]) + 1;
    }

    static String process() {
        long[][] dp = new long[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10_007;
            }
        }
        return String.valueOf(dp[N][10 - 1] % 10_007);
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