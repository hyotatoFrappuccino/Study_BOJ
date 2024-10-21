import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P9657 {
    static int N;
    static int[] dp;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        dp = new int[N + 4];
    }

    static String process() {
        dp[1] = 1;
        dp[3] = 1;
        dp[4] = 1;

        for (int i = 5; i <= N; i++) {
            if ((dp[i - 1] + dp[i - 3] + dp[i - 4]) == 3) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }
        }

        return dp[N] == 1 ? "SK" : "CY";
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