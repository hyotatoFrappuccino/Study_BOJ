import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11720 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(input[i]);
        }
        System.out.println(sum);
    }
}
