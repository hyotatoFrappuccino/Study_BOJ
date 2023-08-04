import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while (N > 1) {
            if (N % 3 == 0) {
                count++;
                N /= 3;
                System.out.println("/3 = " + N);
            } else if (N % 3 == 1) {
                count += 2;
                N -= 1;
                N /= 3;
                System.out.println("-1, /3 = " + N);
            } else if (N % 2 == 0) {
                count++;
                N /= 2;
                System.out.println("/2 = " + N);
            } else {
                count++;
                N -= 1;
                System.out.println("-1 = " + N);
            }
        }
        System.out.println(count);
    }
}
