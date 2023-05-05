import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11005 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);
        int B = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        long cur = N;
        while (cur > 0) {
            if (cur % B < 10) {
                sb.append(cur % B);
            } else {
                sb.append((char)(cur % B - 10 + 'A'));
            }
            cur /= B;
        }
        System.out.println(sb.reverse());
    }
}
