import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2475 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] code = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int n : code) {
            sum += n * n;
        }
        System.out.println(sum % 10);
    }
}