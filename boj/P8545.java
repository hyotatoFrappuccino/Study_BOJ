import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P8545 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        for (int i = 2; i >= 0; i--) {
            System.out.print(input[i]);
        }
    }
}
