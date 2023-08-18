import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P28701 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result1 = fact(N);
        System.out.println(result1);
        System.out.println(result1 * result1);
        System.out.println(result1 * result1);
    }

    public static int fact(int n) {
        if (n == 1)
            return 1;
        return fact(n - 1) + n;
    }
}
