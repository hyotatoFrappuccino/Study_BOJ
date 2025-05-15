import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P27446 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] page = new boolean[N + 1];

        Arrays.fill(page, true);

        for (int i : input) {
            page[i] = false;
        }

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            // 첫번째 페이지라면
            if ((i == 1 && page[i]) || (i > 1 && dp[i - 1] == 0 && page[i])) {
                dp[i] = 7;
            }
            // 1이라면 숫자 배정
            else if (page[i]) {
                // 직전 3칸의 0 개수
                int countZero = 0;
                for (int j = i - 3; j < i; j++) {
                    if (j > 0 && !page[j]) countZero++;
                    if (j > 0 && page[j]) countZero = 0;
                }

                if (countZero == 3) {
                    dp[i] = dp[i - 3] + 7;
                } else if (page[i - 1]) {
                    dp[i] = dp[i - 1] + 2;
                } else if (countZero == 2) {
                    dp[i] = dp[i - 1] + 6;
                } else if (countZero == 1) {
                    dp[i] = dp[i - 1] + 4;
                } else {
                    dp[i] = dp[i - 1] + 2;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }

        System.out.println(dp[N]);
    }
}
