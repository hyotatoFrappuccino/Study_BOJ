import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P11060 {
    static int N;
    static int[] list;
    static int[] dp;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);

        list = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = -1;
        }
        list = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static String process() {
        dp[0] = 0;

        for (int i = 0; i < N - 1; i++) {
            int num = list[i];
            for (int j = i + 1; j < i + 1 + num ; j++) {
                if (j < N && dp[j] == -1 && dp[i] != -1) {
                    dp[j] = dp[i] + 1;
                } else if (j < N && dp[i] != -1) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        
        return String.valueOf(dp[N - 1]);
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