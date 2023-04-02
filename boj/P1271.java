import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P1271 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        BigInteger money = new BigInteger(input[0]);
        BigInteger people = new BigInteger(input[1]);
        System.out.println(money.divide(people));
        System.out.println(money.remainder(people));
    }
}
