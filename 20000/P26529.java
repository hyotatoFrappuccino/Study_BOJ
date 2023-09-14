import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P26529 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testcase; t++) {
            int N = Integer.parseInt(br.readLine());
            long[] fibo = new long[491];
            fibo[0] = 1;
            fibo[1] = 1;
            for (int i = 2; i <= N; i++) {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            }
            sb.append(fibo[N]).append("\n");
        }
        System.out.println(sb);
    }
}
