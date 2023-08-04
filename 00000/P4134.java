import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P4134 {
    public static boolean[] prime;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            BigInteger bi = new BigInteger(br.readLine());
            if (bi.isProbablePrime(10))
                sb.append(bi).append("\n");
            else
                sb.append(bi.nextProbablePrime()).append("\n");
        }
        System.out.println(sb);
    }
}
