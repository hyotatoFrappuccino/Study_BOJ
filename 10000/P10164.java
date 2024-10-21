import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P10164 {
    static int N;
    static int M;
    static int K;
    static int[][] dp;
    static final int MAX_LEN = 15;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static String process() {
        dp = new int[MAX_LEN][MAX_LEN];
        for (int i = 0; i < MAX_LEN; i++) {
            dp[i][0] = 1;
            dp[0][i] = 1;
        }

        for (int i = 1; i < MAX_LEN; i++) {
            for (int j = 1; j < MAX_LEN; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        int x = (K - 1) / M ;
        int y = (K - 1) % M;

        if (K == 0) {
            x = N - 1;
            y = M - 1;
        }

        int routeA = dp[x][y];
        int routeB = dp[N - 1 - x][M - 1 - y];

        return String.valueOf(routeA * routeB);
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