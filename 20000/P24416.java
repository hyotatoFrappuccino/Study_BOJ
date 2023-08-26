import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P24416 {
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fib1(N);
        fib2(N);
        System.out.println(count1 + " " + count2);
    }

    public static int fib1(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        }
        else return fib1(n - 1) + fib1(n - 2);
    }

    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    public static void fib2(int n) {
        int[] fib = new int[41];
        fib[1] = fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            count2++;
        }
    }
}
