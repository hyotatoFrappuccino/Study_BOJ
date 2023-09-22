import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P19947 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int[] dp = new int[11];
        dp[0] = H;
        dp[1] = (int) (H * 1.05);
        dp[2] = (int) (dp[1] * 1.05);
        dp[3] = Math.max((int) (dp[2] * 1.05), (int) (H * 1.2));
        dp[4] = Math.max((int) (dp[1] * 1.2), (int) (dp[3] * 1.05));
        dp[5] = Math.max((int) (H * 1.35), Math.max((int) (dp[4] * 1.05), (int) (dp[2] * 1.2)));
        for (int i = 6; i <= Y; i++) {
            dp[i] = Math.max((int) (dp[i-1] * 1.05), Math.max((int) (dp[i-3] * 1.2), (int) (dp[i-5] * 1.35)));
        }
        if (Y < 6)
            System.out.println(dp[Y]);
        else {
            Arrays.sort(dp);
            System.out.println(dp[10]);
        }
    }
}
