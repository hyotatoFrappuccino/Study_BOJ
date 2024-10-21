import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P16493 {
    static int N;
    static int M;
    static int[] days;
    static int[] pages;
    static int max;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        days = new int[M];
        pages = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(lines[i + 1]);
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }
    }

    static String process() {
        // i일이 남았을 때 j번째 책까지 고려했을 때 읽을 수 있는 최대 페이지 수
        int[][] dp = new int[N + 1][M + 1];
        max = 0;

        // i번째 책
        for (int i = 1; i <= M; i++) {
            for (int remain_days = 0; remain_days <= N; remain_days++) {
                // i번째(i - 1) 책을 읽지 않는 경우
                dp[remain_days][i] = dp[remain_days][i - 1];

                // i번째 책을 읽는 경우. 남은 대출 기한이 있다면
                if (remain_days - days[i - 1] >= 0) {
                    dp[remain_days][i] = Math.max(dp[remain_days][i], dp[remain_days - days[i - 1]][i - 1] + pages[i - 1]);
                }

                max = Math.max(max, dp[remain_days][i]);
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