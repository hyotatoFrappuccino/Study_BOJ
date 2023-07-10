import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2577 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        String multiply = Integer.toString(A*B*C);
        for (int i = 0; i <= 9; i++) {
            int count = 0;
            for (char c : multiply.toCharArray()) {
                if (c - '0' == i) count++;
            }
            System.out.println(count);
        }

    }
}
