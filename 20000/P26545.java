import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P26545 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        System.out.println(sum);
    }
}
