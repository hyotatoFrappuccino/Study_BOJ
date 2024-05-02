import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainP15990 {
    static int T;
    static String[] input;
    static StringBuilder output;
    static final int divide = 1_000_000_009;

    static void input(String[] lines) {
        T = Integer.parseInt(lines[0]);
        input = Arrays.copyOfRange(lines, 1, lines.length);
        output = new StringBuilder();
    }

    static String process() {;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(input[i]);
            int[][] dp = new int[N+1][3+1];
            if (N >= 1) {
                dp[1][1] = 1;
                dp[1][2] = 0;
                dp[1][3] = 0;
            }
            if (N >= 2) {
                dp[2][1] = 0;
                dp[2][2] = 1;
                dp[2][3] = 0;
            }
            if (N >= 3) {
                dp[3][1] = 1;
                dp[3][2] = 1;
                dp[3][3] = 1;
            }
            for (int j = 4; j <= N; j++) {
                dp[j][1] = (dp[j - 1][2] + dp[j - 1][3]) % divide;
                dp[j][2] = (dp[j - 1][1] + dp[j - 1][3]) % divide;
                dp[j][3] = (dp[j - 1][1] + dp[j - 1][2]) % divide;
                for (int k = 1; k <= 3; k++) {
                    System.out.println(dp[j][k]);
                }
            }
            output.append((dp[N][1] + dp[N][2] + dp[N][3]) % divide).append("\n");
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