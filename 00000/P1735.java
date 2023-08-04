import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1735 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = a * d + b * c;
        int f = b * d;
        int g = gcd(e, f);
        System.out.println(e/g + " " + f/g);
    }

    public static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
}
