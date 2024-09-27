import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P17484 {
    static int N;
    static int M;
    static int[][] matrix;
    static int[][][] dp;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(lines[i + 1]);
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M][3];
    }

    static String process() {
        for (int i = 0; i < M; i++) {
            if (i > 0) {
                dp[1][i][0] = matrix[0][i - 1] + matrix[1][i];
            }
            dp[1][i][1] = matrix[0][i] + matrix[1][i];
            if (i < M - 1) {
                dp[1][i][2] = matrix[0][i + 1] + matrix[1][i];
            }
        }

        for (int i = 0; i < N; i++) {
            dp[i][0][0] = Integer.MAX_VALUE;
            dp[i][M - 1][2] = Integer.MAX_VALUE;
        }

        for (int i = 2; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j > 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + matrix[i][j];
                }
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + matrix[i][j];
                if (j < M - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + matrix[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[N - 1][i][j]);
            }
        }

        return String.valueOf(min);
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