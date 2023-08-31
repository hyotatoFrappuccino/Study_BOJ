import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P24309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        BigInteger c = new BigInteger(br.readLine());
        System.out.println(b.subtract(c).divide(a));
    }
}