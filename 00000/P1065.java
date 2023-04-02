import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1065 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        if (N < 100) result = N;
        else{
            result += 99;
            for (int i = 100; i <= N; i++) {
                String num = String.valueOf(i);
                if (num.charAt(0) - num.charAt(1) == (num.charAt(1) - num.charAt(2))) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
