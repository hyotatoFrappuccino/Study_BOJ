import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P11055 {
    static int N;
    static int[] list;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static String process() {
        int[] dp = new int[N];
        int maxSum = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = list[i];
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i] && dp[i] < dp[j] + list[i]) {
                    dp[i] = dp[j] + list[i];
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        return String.valueOf(maxSum);
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