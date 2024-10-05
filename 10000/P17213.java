import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P17213 {
    static int N;
    static int M;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        M = Integer.parseInt(lines[1]);
    }

    static String process() {
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= M; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int sum = 0;
                for (int k = 1; k <= j - 1; k++) {
                    sum += dp[i - 1][k];
                }
                dp[i][j] = sum;
            }
        }

        return String.valueOf(dp[N][M]);
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