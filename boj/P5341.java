import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5341 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int sum = 0;
            for (int i = n; i > 0; i--) {
                sum += i;
            }
            System.out.println(sum);
        }
    }
}
