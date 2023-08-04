import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2609 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int gcd = gcd(N, M);
        System.out.println(gcd);
        System.out.println(N * M / gcd);
    }

    public static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
}
