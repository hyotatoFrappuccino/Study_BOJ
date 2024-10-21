import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P25418 {
    static int A;
    static int K;
    static int[][] DP;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static String process() {
        DP = new int[K + 1][2];

        DP[A][0] = 0;
        DP[A][1] = 0;

        for (int i = A + 1; i <= K; i++) {
            DP[i][0] = Math.min(DP[i - 1][0], DP[i - 1][1]) + 1;
            if (i / 2 >= A && (i & 1) == 0) {
                DP[i][1] = Math.min(DP[i / 2][0], DP[i / 2][1]) + 1;
            } else {
                DP[i][1] = Integer.MAX_VALUE;
            }
        }

        return String.valueOf(Math.min(DP[K][0], DP[K][1]));
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