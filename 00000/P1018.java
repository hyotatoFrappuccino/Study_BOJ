import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1018 {
    static char[][] matrix;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }
        int min = N * M;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int result = getFillCount(i, j);
                if (result < min) min = result;
            }
        }
        System.out.println(min);


    }

    public static int getFillCount(int x, int y){
        int count = 0;
        char comp = matrix[x][y];
        for (int i = x; i < x + 8; i++) {
            for (int j = y + 1; j < y + 8; j++) {
                if (matrix[i][j] == comp){
                    count++;
                }
                if (comp == 'W') comp = 'B';
                else comp = 'W';
            }
        }
        System.out.println("x: " + x + ", y: " + y + ", count: " + count);
        return count;
    }
}
