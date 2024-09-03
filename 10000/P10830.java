import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P10830 {
    static int N;
    static long B;
    static int[][] A;
    static int[][] result;
    static final int MOD = 1_000;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(lines[i + 1]);
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        output = new StringBuilder();
    }

    static String process() {
        result = fac(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                output.append(result[i][j]);

                if (j < N - 1) {
                    output.append(" ");
                }
            }
            output.append("\n");
        }

        return output.toString();
    }

    private static int[][] fac(long b) {
        if (b == 1L) {
            return A;
        }

        int[][] temp = fac(b / 2);
        temp = multiply(temp, temp);

        if ((b & 1) == 1) {
            temp = multiply(temp, A);
        }

        return temp;
    }

    static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum % MOD;
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