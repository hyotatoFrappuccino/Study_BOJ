import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2491 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp0 = new int[N];
        int[] dp1 = new int[N];
        dp0[0] = 1;
        dp1[0] = 1;
        int before = Integer.parseInt(st.nextToken());
        int max = 1;
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num >= before) dp0[i] = dp0[i-1] + 1;
            else dp0[i] = 1;
            if (num <= before) dp1[i] = dp1[i-1] + 1;
            else dp1[i] = 1;
            max = Math.max(max, Math.max(dp0[i], dp1[i]));
            before = num;
        }
        System.out.println(max);
    }
}
