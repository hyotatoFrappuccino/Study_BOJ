import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1660 {
    static int N;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
    }

    static String process() {
        int[] dp = new int[N + 1];
        int gap = 2;
        int init = 1;
        int sum = 0;
        List<Integer> list = new ArrayList<>();

        while (sum + init <= N) {
            sum += init;
            init += gap++;
            dp[sum] = 1;
            list.add(sum);
        }

        for (int i = 2; i <= N; i++) {
            if (dp[i] != 1) {
                int min = dp[i - 1] + 1;
                for (int one : list) {
                    if (one > i) break;
                    min = Math.min(min, dp[i - one] + 1);
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