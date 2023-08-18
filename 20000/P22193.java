import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P22193 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());
        System.out.println(A.multiply(B));
    }
}
