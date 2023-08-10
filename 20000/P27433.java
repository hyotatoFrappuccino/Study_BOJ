import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P27433 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(fact(N));
    }

    public static long fact(int N) {
        if (N <= 1) return 1;
        else return N * fact(N - 1);
    }
}
