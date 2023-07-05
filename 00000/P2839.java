import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2839 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean exits = false;
        int min = N / 3;
        for (int i = 0; i <= N / 5; i++) {
            for (int j = 0; j <= N / 3; j++) {
                if (N == i * 5 + j * 3 && i + j <= min) {
                    min = i + j;
                    exits = true;
                }
            }
        }
        if (exits) System.out.println(min);
        else System.out.println(-1);
    }
}
