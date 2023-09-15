import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P10826 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] fibo = new BigInteger[10001];
        fibo[0] = BigInteger.ZERO;
        fibo[1] = BigInteger.ONE;
        for (int i = 2; i <= N; i++) {
            fibo[i] = fibo[i-1].add(fibo[i-2]);
        }
        System.out.println(fibo[N]);
    }
}
