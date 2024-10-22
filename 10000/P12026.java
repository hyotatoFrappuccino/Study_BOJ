import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P12026 {
    static int N;
    static char[] list;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = lines[1].toCharArray();
    }

    static String process() {
        int[] dp = new int[N];
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            char cur = list[i];
            char next;
            if (cur == 'B') {
                next = 'O';
            } else if (cur == 'O') {
                next = 'J';
            } else {
                next = 'B';
            }

            for (int j = i + 1; j < N; j++) {
                if (list[j] == next && (i == 0 || dp[i] != 0)) {
                    int eng = dp[i] + (int) Math.pow(j - i, 2);
                    if (dp[j] == 0) {
                        dp[j] = eng;
                    } else {
                        dp[j] = Math.min(dp[j], eng);
                    }
                }
            }
        }

        if (N == 1) {
            return "0";
        } else if (dp[N - 1] == 0) {
            return "-1";
        } else {
            return String.valueOf(dp[N - 1]);
        }
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