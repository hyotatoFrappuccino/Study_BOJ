import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[N+1];
        // 소수면 false, 아니면 true
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!prime[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
