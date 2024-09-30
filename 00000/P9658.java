import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P9658 {
    static int N;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
    }

    static String process() {
        int[] dp = new int[N + 5];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            if ((dp[i - 1] + dp[i - 3] + dp[i - 4]) > 0) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }
        }

        return dp[N] == 0 ? "SK" : "CY";
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