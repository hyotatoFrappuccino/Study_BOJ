import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10872 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = n - 1; i > 0; i--) {
            n *= i;
        }
        if (n == 0) System.out.println("1");
        else System.out.println(n);
    }
}
