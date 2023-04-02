import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2563 {
    final static int fullSIZE = 100;
    final static int paperSize = 10;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] matrix = new int[fullSIZE][fullSIZE];
        for (int i = 0; i < num; i++) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = xy[0];
            int y = xy[1];
            for (int j = 0; j < paperSize; j++) {
                for (int k = 0; k < paperSize; k++) {
                    matrix[j+x][k+y] = 1;
                }
            }
        }
        int sum = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] == 1) sum += 1;
            }
        }
        System.out.println(sum);
    }
}
