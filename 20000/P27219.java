import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P27219 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String sb = "V".repeat(N / 5) +
                    "I".repeat(N % 5);
        System.out.println(sb);
    }
}
