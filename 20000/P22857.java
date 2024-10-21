import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P22857 {
    static int N;
    static int K;
    static int[] list;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];
        list = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static String process() {
        int[][] dp = new int[N + 1][K + 1];
        int max = 0;

        // 0 : 안 지운 것
        // 1 : 지운 것
        for (int i = 1; i <= N; i++) {
            if ((list[i - 1] & 1) == 1) {
                // 홀수라면

                for (int j = 0; j <= K; j++) {
                    // 지우는 경우
                    if (j > 0) {
                        int num = dp[i - 1][j - 1];
                        dp[i][j] = num;
                        max = Math.max(max, num);
                    }

                    // 안 지우는 경우
//                    dp[i][j][0] = 0;
                }
            } else {
                // 짝수라면
                for (int j = 0; j <= K; j++) {
                    int num = dp[i - 1][j] + 1;
                    dp[i][j] = num;
                    max = Math.max(max, num);
//                    dp[i][j][1] = 0;
                }
            }
        }

        return String.valueOf(max);
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