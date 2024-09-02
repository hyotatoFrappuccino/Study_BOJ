import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P2740 {
    static int N;
    static int M;
    static int K;
    static int[][] A;
    static int[][] B;
    static int[][] result;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A  = new int[N][M];
        for (int i = 0; i < N; i++) {
            A[i] = Arrays.stream(lines[1 + i].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        st = new StringTokenizer(lines[1 + N]);
        st.nextToken();
        K = Integer.parseInt(st.nextToken());
        B = new int[M][K];
        for (int i = 0; i < M; i++) {
            B[i] = Arrays.stream(lines[1 + N + 1 + i].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        result = new int[N][K];

        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                output.append(result[i][j]).append(" ");
            }
            output.append("\n");
        }

        return output.toString();
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