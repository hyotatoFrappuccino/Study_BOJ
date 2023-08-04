import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P13909 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int cur = 0;
        int plus = 3;
        do {
            cur += plus;
            plus += 2;
            count++;
        } while (N > cur);
        System.out.println(count);
    }
}
