import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P30328 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N * 4000);
        br.close();
    }
}
