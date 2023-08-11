import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P15829 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        BigInteger hash = new BigInteger("0");
        for (int i = 0; i < N; i++) {
            hash = hash.add(new BigInteger("31").pow(i).multiply(BigInteger.valueOf(input[i] - 96)).remainder(BigInteger.valueOf(1234567891)));
        }
        System.out.println(hash.remainder(BigInteger.valueOf(1234567891)));
    }
}
