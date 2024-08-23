import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P12865 {
    static int N;
    static int K;
    static int[] W;
    static int[] V;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(lines[i + 1]);
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
    }

    static String process() {
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
//                배낭의 무게가 담을 물건의 무게보다 큰 경우
                if (j >= W[i - 1]) {
//                    가치의 최댓값을 계산
                    dp[i][j] = Math.max(dp[i - 1][j - W[i - 1]] + V[i - 1], dp[i - 1][j]);
                }
//                공간이 없어 담을 수 없는 경우 (담지 않는 경우)
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }

        return String.valueOf(dp[N][K]);
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