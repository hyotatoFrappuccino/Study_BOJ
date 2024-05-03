import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P15988 {
    static int T;
    static long divide = 1_000_000_009;
    static int[] listN;
    static StringBuilder output;

    static void input(String[] lines) {
        T = Integer.parseInt(lines[0]);
        listN = new int[T];
        for (int i = 0; i < T; i++) {
            listN[i] = Integer.parseInt(lines[i + 1]);
        }
        output = new StringBuilder();
    }

    static String process() {
        long[] dp = new long[1_000_000 + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % divide;
        }

        for (int testcase = 0; testcase < T; testcase++) {
            int N = listN[testcase];
            output.append(dp[N] % divide).append("\n");
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