import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1929 {
    public static void main(String[] args) throws Exception {
        // 다시 생각해보자








        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (prime[i]) continue;

            if (i >= M) sb.append(i).append("\n");
            for (int j = i + 1; j <= N; j += i) {
                prime[j] = true;
            }
        }
        System.out.println(sb);
    }
}
