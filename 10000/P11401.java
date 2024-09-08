import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11401 {
    static final long P = 1_000_000_007;
    static int N;
    static int K;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static String process() {
        return String.valueOf(factorial(N) * pow(factorial(K) * factorial(N - K) % P, P - 2) % P);
    }

    static long pow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= base;
                result %= P;
            }
            base *= base;
            base %= P;
            exp >>= 1;
        }

        return result;
    }

    static long factorial(long n) {
        long res = 1L;

        while (n > 1) {
            res = (res * n--) % P;
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.println(process());
    }

    private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);
        return linesArray;
    }
}