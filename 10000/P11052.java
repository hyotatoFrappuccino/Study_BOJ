import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11052 {
    static int N;
    static int[] price;
    static int[] dp;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        StringTokenizer st = new StringTokenizer(lines[1]);
        price = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N + 1];
    }

    static String process() {
        dp[1] = price[1];
        for (int i = 2; i <= N; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, dp[j] + dp[i - j]);
            }
            dp[i] = Math.max(max, price[i]);
        }
        return String.valueOf(dp[N]);
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