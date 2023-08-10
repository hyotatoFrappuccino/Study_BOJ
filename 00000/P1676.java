import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;

public class P1676 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String result = String.valueOf(fact(BigInteger.valueOf(N)));
        int count = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            if (result.charAt(i) != '0') break;
            if (result.charAt(i) == '0') count++;
        }
        System.out.println(count);
    }

    public static BigInteger fact(BigInteger n) {
        if (Objects.equals(n, BigInteger.ZERO)) return BigInteger.ONE;
        else return fact(n.subtract(BigInteger.ONE)).multiply(n);
    }
}
