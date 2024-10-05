import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P17271 {
    static int N;
    static int M;
    static final int MOD = 1_000_000_007;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    static String process() {
        int[] dp = new int[N + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
//            A기술을 또 쓰는 경우는 같은 경우 (밑에서 못 더해줄 수 있으니 미리 계산함)
            dp[i] = dp[i - 1];
            if (i - M < 0) continue;
//            B기술을 쓰는 경우는 다른 경우이므로 두 경우의 수를 더함
            dp[i] = (dp[i] + dp[i - M]) % MOD;
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