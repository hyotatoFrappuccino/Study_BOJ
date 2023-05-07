import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2903 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 2;
        int input = Integer.parseInt(br.readLine());
        for (int i = 0; i < input; i++) {
            n = n + n - 1;
        }
        System.out.println(n * n);
    }
}
