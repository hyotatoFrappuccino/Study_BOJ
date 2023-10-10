import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P24417 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fib1 = new int[N+2];
        fib1[5] = 5;
        fib1[6] = 8;
        for (int i = 7; i <= N; i++) {
            fib1[i] = (fib1[i - 1] + fib1[i - 2]) % 1000000007;
        }
        System.out.println(fib1[N] + " " + (N - 2));
    }
}
