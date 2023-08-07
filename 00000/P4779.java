import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P4779 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        recur((int) Math.pow(3, N), (int) Math.pow(3, N));
    }

    public static void recur(int len, int n) {
        n /= 3;
        if (n < 1) return;
        StringBuilder sb = new StringBuilder();
        sb.append("-".repeat(Math.max(0, n)));
        sb.append(" ".repeat(Math.max(0, n * 2 - n)));
        sb.append("-".repeat(Math.max(0, n * 3 - n * 2)));
        System.out.println(sb);
        recur(len, n);
    }
}
