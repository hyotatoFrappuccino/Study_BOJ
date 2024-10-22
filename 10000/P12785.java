import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P12785 {
    static int W, H, X, Y;
    static final int MOD = 1_000_007;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(lines[1]);
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }

    static String process() {
        int[][] dp = new int[200][200];
        for (int i = 0; i < 200; i++) {
            dp[i][0] = 1;
            dp[0][i] = 1;
        }

        for (int i = 1; i < 200; i++) {
            for (int j = 1; j < 200; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        long res = ((long) dp[X - 1][Y - 1] * dp[W - X][H - Y]) % (long) MOD;
        return String.valueOf(res);
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