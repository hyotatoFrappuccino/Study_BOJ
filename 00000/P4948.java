import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P4948 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int M = Integer.parseInt(br.readLine());
            if (M == 0) break;
            int N = M * 2;
            M++;
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
            int count = 0;
            for (int i = M; i <= N; i++) {
                if (!prime[i]) count++;
            }
            System.out.println(count);
        }
    }
}
