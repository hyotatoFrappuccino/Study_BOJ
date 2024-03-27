import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;

public class P4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);
            BigInteger bi = new BigInteger("1");
            while (true) {
                if (Objects.equals(bi.divideAndRemainder(BigInteger.valueOf(num))[1], BigInteger.ZERO)) {
                    System.out.println(bi.toString().length());
                    break;
                }
                bi = bi.multiply(BigInteger.valueOf(10L)).add(BigInteger.ONE);
            }
        }
    }
}
