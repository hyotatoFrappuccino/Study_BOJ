import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1890 {
    static int N;
    static int[][] matrix;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    static String process() {
        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) {
                    break;
                }
                int nextIdx = matrix[i][j];

                if (nextIdx == 0) {
                    break;
                }

                if (i + nextIdx < N) {
                    dp[i + nextIdx][j] += dp[i][j];
                }

                if (j + nextIdx < N) {
                    dp[i][j + nextIdx] += dp[i][j];
                }
            }
        }

        return String.valueOf(dp[N - 1][N - 1]);
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