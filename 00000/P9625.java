import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9625 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] A = new int[45];
        int[] B = new int[45];
        A[0] = 0;
        A[1] = 1;
        B[0] = 1;
        B[1] = 1;
        for (int i = 2; i < K; i++) {
            A[i] = A[i-1] + A[i-2];
            B[i] = B[i-1] + B[i-2];
        }
        System.out.println(A[K-1] + " " + B[K-1]);
    }
}
