import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P16931 {
    static int N;
    static int M;
    static int[][] matrix;
    static int result;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        result = 0;
    }

    static String process() {
        // 밑면, 윗면
        result += N * M * 2;

        // 옆면 - 동서
        for (int i = 0; i < N; i++) {
            result += matrix[i][M - 1];
            result += matrix[i][0];
        }

        // 옆면 - 남북
        for (int i = 0; i < M; i++) {
            result += matrix[N - 1][i];
            result += matrix[0][i];
        }

        // 사이사이
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 1; j++) {
                result += Math.abs(matrix[i][j] - matrix[i][j + 1]);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                result += Math.abs(matrix[i][j] - matrix[i + 1][j]);
            }
        }


        return String.valueOf(result);
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