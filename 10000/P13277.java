import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P13277 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        System.out.println(new BigInteger(input[0]).multiply(new BigInteger(input[1])));

    }
}
