import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P17291 {
    static int N;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
    }

    static String process() {
        int[] dp = new int[N + 5];
        dp[1] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < dp[i]; j++) {
                dp[i + 1]++;
                dp[i + 2]++;
                dp[i + 3]++;
                if ((i & 1) == 0) {
                    dp[i + 4]++;
                }
            }
        }

        return String.valueOf(dp[N + 1]);
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