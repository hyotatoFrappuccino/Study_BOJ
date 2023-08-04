import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11050 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (N == M) System.out.println(1);
        else System.out.println(fact(N)/(fact(N-M)*fact(M)));
    }

    public static int fact(int n) {
        if (n <= 1) return 1;
        return n * fact(n - 1);
    }
}
