import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P11444 {
    static long n;
    static final int[][] A = {{1, 1}, {1, 0}};
    static final int MOD = 1_000_000_007;

    static void input(String[] lines) {
        n = Long.parseLong(lines[0]);
    }

    static String process() {
        int[][] ints = powMatrix(A, n);


        return String.valueOf(ints[0][1]);
    }

    static int[][] powMatrix(int[][] matrix, long B) {
        if (B == 1) return A;
        int[][] t = powMatrix(matrix, B / 2);
        int[][] temp = multiplyMatrix(t, t);
        if ((B & 1) == 1) {
            temp = multiplyMatrix(temp, A);
        }
        return temp;
    }

    static int[][] multiplyMatrix(int[][] A, int[][] B) {
        int[][] result = new int[2][2];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                long sum = 0;
                for (int k = 0; k < A.length; k++) {
                    sum += ((long) A[i][k] * B[k][j]) % MOD;
                }
                result[i][j] = (int) (sum % MOD);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.println(process());
    }

    private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);
        return linesArray;
    }
}