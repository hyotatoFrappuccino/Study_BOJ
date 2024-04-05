import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P17425 {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] list = new long[1_000_000 + 1];
        for (int i = 1; i <= 1_000_000; i++) {
            long sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += (long) (i / j) * j;
            }
            list[i] = sum;
        }
        br.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
