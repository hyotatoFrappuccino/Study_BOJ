import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2688 {
    static int T;
    static int[] list;
    static long[] dp;
    static long[] result;
    static StringBuilder output;

    static void input(String[] lines) {
        T = Integer.parseInt(lines[0]);
        list = new int[T];
        for (int i = 0; i < T; i++) {
            list[i] = Integer.parseInt(lines[i + 1]);
        }
        output = new StringBuilder();
    }

    static String process() {
        dp = new long[10];
        for (int i = 0; i < 10; i++) {
            dp[i] = 1;
        }
        result = new long[64];
        for (int i = 0; i < 64; i++) {
            long sum = 0;
            for (long num : dp) {
                sum += num;
            }
            result[i] = sum;
            for (int j = 0; j < 10; j++) {
                long temp = sum;
                sum -= dp[j];
                dp[j] = temp;
            }
        }

        // 결과 출력
        for (int i : list) {
            output.append(result[i - 1]).append("\n");
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