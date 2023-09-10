import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11727 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fibo = new int[N+1];
        fibo[1] = 1;
        if (N > 1)
            fibo[2] = 3;
        for (int i = 3; i <= N; i++) {
            fibo[i] = (fibo[i-1] + (fibo[i-2] * 2)) % 10007;
        }
        System.out.println(fibo[N]);
    }
}
