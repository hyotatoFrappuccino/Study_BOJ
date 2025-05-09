import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long A = a[N - 2];
        long B = a[N - 1];
        long C = 1;

        for (int i = 1; i < N - 1; i++) {
            long tempB = A * B + C;
            C = B;
            B = tempB;
            A = a[N - 2 - i];

//            System.out.println("A : " + A + ", B : " + B + ", C : " + C);
        }

        long tempB = A * B + C;
        C = B;
        B = tempB;

//        System.out.println("result = A : " + A + ", B : " + B + ", C : " + C);
        System.out.println((B - C) + " " + B);
    }
}
