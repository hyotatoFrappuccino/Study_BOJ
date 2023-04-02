import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class P8437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger total = new BigInteger(br.readLine());
        BigDecimal sub = new BigDecimal(br.readLine());
        BigInteger num1 = total.divide(new BigInteger("2")).add(sub.divide(new BigDecimal("2"), RoundingMode.CEILING).toBigInteger());
        System.out.println(num1);
        System.out.println(total.subtract(num1));
    }
}
