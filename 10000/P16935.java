import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P16935 {
    static int N;
    static int M;
    static int R;
    static int[][] matrix;
    static int[] cal;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(lines[i + 1]);
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cal = Arrays.stream(lines[N + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        output = new StringBuilder();
    }

    static String process() {
        for (int i : cal) {
            rotate(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                output.append(matrix[i][j]);
                if (j < M - 1) {
                    output.append(" ");
                }
            }
            output.append("\n");
        }
        return output.toString();
    }

    private static void rotate(int type) {
        if (type == 1) {
            for (int i = 0; i < N / 2; i++) {
                int[] temp = matrix[N - 1 - i];
                matrix[N - 1 - i] = matrix[i];
                matrix[i] = temp;
            }
        } else if (type == 2) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M / 2; j++) {
                    int temp = matrix[i][M - 1 - j];
                    matrix[i][M - 1 - j] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        } else if (type == 3) {
            int[][] newMatrix = new int[M][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    newMatrix[j][N - 1 - i] = matrix[i][j];
                }
            }
            int temp = N;
            N = M;
            M = temp;
            matrix = newMatrix.clone();
        } else if (type == 4) {
            int[][] newMatrix = new int[M][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    newMatrix[M - 1 - j][i] = matrix[i][j];
                }
            }
            int temp = N;
            N = M;
            M = temp;
            matrix = newMatrix.clone();
        } else if (type == 5) {
            int[][] newMatrix = new int[N][M];
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < M / 2; j++) {
                    newMatrix[i][j + M / 2] = matrix[i][j];
                    newMatrix[i + N / 2][j + M / 2] = matrix[i][j + M / 2];
                    newMatrix[i + N / 2][j] = matrix[i + N / 2][j + M / 2];
                    newMatrix[i][j] = matrix[i + N / 2][j];
                }
            }
            matrix = newMatrix.clone();
        } else if (type == 6) {
            int[][] newMatrix = new int[N][M];
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < M / 2; j++) {
                    newMatrix[i][j + M / 2] = matrix[i + N / 2][j + M / 2];
                    newMatrix[i + N / 2][j + M / 2] = matrix[i + N / 2][j];
                    newMatrix[i + N / 2][j] = matrix[i][j];
                    newMatrix[i][j] = matrix[i][j + M / 2];
                }
            }
            matrix = newMatrix.clone();
        }
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