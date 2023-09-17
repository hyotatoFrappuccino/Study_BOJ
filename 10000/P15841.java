import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;

public class P15841 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        while (!Objects.equals(input = br.readLine(), "-1")){
            int N = Integer.parseInt(input);
            BigInteger[] fibo = new BigInteger[491];
            fibo[0] = BigInteger.ZERO;
            fibo[1] = BigInteger.ONE;
            for (int i = 2; i <= N; i++) {
                fibo[i] = fibo[i - 1].add(fibo[i - 2]);
            }
            sb.append("Hour ").append(N).append(": ").append(fibo[N]).append(" cow(s) affected").append("\n");
        }
        System.out.println(sb);
    }
}
