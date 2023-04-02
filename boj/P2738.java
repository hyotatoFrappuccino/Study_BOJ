import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2738 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmInput = br.readLine().split(" ");
        int N = Integer.parseInt(nmInput[0]);
        int M = Integer.parseInt(nmInput[1]);
        int[][] matrix = new int[N][M];
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < N; i++) {
                int[] rowInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < M; j++) {
                    matrix[i][j] += rowInput[j];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
