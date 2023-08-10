import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11729 {
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        sb.append((int) Math.pow(2, N) - 1).append("\n");
        hanoiTower(N, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoiTower(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        hanoiTower(n - 1, start, to, mid);
        sb.append(start).append(" ").append(to).append("\n");
        hanoiTower(n - 1, mid, start, to);
    }
}
