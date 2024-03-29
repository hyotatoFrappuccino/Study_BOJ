import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2748 {
    public static void main(String[] args) throws Exception {
        //noinspection DuplicatedCode
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] fibo = new long[91];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= N; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        System.out.println(fibo[N]);
    }
}
