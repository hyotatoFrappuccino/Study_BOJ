import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P24086 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        System.out.println(B - A);
    }
}
