import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P2167 {
    static int N, M, K;
    static int[][] matrix;
    static int[] ii, jj, xx, yy;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        K = Integer.parseInt(lines[1 + N]);
        ii = new int[K];
        jj = new int[K];
        xx = new int[K];
        yy = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(lines[2 + N + i]);
            ii[i] = Integer.parseInt(st.nextToken());
            jj[i] = Integer.parseInt(st.nextToken());
            xx[i] = Integer.parseInt(st.nextToken());
            yy[i] = Integer.parseInt(st.nextToken());
        }

        output = new StringBuilder();
    }

    static String process() {
        int[][] dp = new int[N][M];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + matrix[i][j];
            }
        }

        for (int i = 0; i < K; i++) {
            int num = dp[xx[i] - 1][yy[i] - 1];
            int minusA = 0;
            if (ii[i] - 2 >= 0) minusA = dp[ii[i] - 2][yy[i] - 1];
            int minusB = 0;
            if (jj[i] - 2 >= 0) minusB = dp[xx[i] - 1][jj[i] - 2];
            int plus = 0;
            if (ii[i] - 2 >= 0 && jj[i] - 2 >= 0) plus = dp[ii[i] - 2][jj[i] - 2];
            output.append(num - minusA - minusB + plus).append("\n");
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