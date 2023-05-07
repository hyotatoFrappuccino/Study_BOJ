import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2720 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            int C = Integer.parseInt(br.readLine());
            int quarter = C / 25;
            C = C % 25;
            int dime = C / 10;
            C = C % 10;
            int nickel = C / 5;
            C = C % 5;
            System.out.printf("%d %d %d %d\n", quarter, dime, nickel, C);
        }
    }
}
