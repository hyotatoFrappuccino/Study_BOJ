import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class P16099 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] list = br.readLine().split(" ");
            BigInteger n1 = new BigInteger(list[0]);
            BigInteger n2 = new BigInteger(list[1]);
            BigInteger n3 = new BigInteger(list[2]);
            BigInteger n4 = new BigInteger(list[3]);
            int compare = n1.multiply(n2).compareTo(n3.multiply(n4));
            if (compare == 1)
                System.out.println("TelecomParisTech");
            else if (compare == -1)
                System.out.println("Eurecom");
            else
                System.out.println("Tie");
        }
    }
}
