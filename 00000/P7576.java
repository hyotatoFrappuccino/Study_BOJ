import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P7576 {
    static int M;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MN = br.readLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int day = 0;
        while (true) {
            int[][] after = new int[N][M];
            deepCopy(matrix, after);
            boolean change = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 1) {
                        if (isValidPos(i-1, j, matrix, after)) {
                            change = true;
                        }
                        if (isValidPos(i, j-1, matrix, after)) {
                            change = true;
                        }
                        if (isValidPos(i, j+1, matrix, after)) {
                            change = true;
                        }
                        if (isValidPos(i+1, j, matrix, after)) {
                            change = true;
                        }
                    }
                }
            }
            if (change) {
                day++;
                deepCopy(after, matrix);
            }
            else break;
        }

        boolean done = true;
        for (int[] ints : matrix) {
            if (done) {
                for (int anInt : ints)
                    if (anInt == 0) {
                        done = false;
                        break;
                    }
            }
        }
        if (done) System.out.println(day);
        else System.out.println(-1);
    }

    public static boolean isValidPos(int x, int y, int[][] matrix, int[][] after) {
        if (x >= 0 && x < N && y >= 0 && y < M && matrix[x][y] == 0) {
            after[x][y] = 1;
            return true;
        } else return false;
    }

    public static void deepCopy(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(a[i], 0, b[i], 0, a[0].length);
        }
    }
}
