import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1699 {
    static int N;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
    }

    static String process() {
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            int sqrt = (int) Math.sqrt(i);
            int pow = (int) Math.pow(sqrt, 2);
            if (i == pow) {
                dp[i] = 1;
            }
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= sqrt; j++) {
                    min = Math.min(min, dp[(int) Math.pow(j, 2)] + dp[i - (int) Math.pow(j, 2)]);
                }
                dp[i] = min;
            }
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