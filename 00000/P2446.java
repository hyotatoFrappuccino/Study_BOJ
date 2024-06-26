import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2446 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(" ".repeat(i - 1)).append("*".repeat((2 * N) - (i * 2 - 1))).append("\n");
        }
        for (int i = N - 1; i >= 1; i--) {
            sb.append(" ".repeat(i - 1)).append("*".repeat((2 * N) - (i * 2 - 1))).append("\n");
        }
        System.out.println(sb);
    }
}
