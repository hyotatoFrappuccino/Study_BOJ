import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P6749 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        System.out.println(M + M - N);
    }
}
