import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P8871 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((n + 1) * 2 + " " + (n + 1) * 3);
    }
}
