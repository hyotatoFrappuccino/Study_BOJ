import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P2420 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        BigInteger N = new BigInteger(input[0]);
        BigInteger M = new BigInteger(input[1]);
        System.out.println(N.subtract(M).abs());
    }
}
