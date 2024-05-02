import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14391 {
    static int N;
    static int M;
    static int[][] matrix;
    static int max;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] row = lines[i + 1].toCharArray();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = row[j] - '0';
            }
        }
        max = 0;
    }

    static String process() {
        for (int bit = 0; bit < 1 << N * M; bit++) {
            StringBuilder num = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if ((~bit & (1 << ((N - i) * M - j - 1))) > 0)
                        num.append(matrix[i][j]);
                    else
                        num.append("\n");
                }
                num.append("\n");
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if ((bit & (1 << (M * N - 1) - (j * M +i))) > 0)
                        num.append(matrix[j][i]);
                    else
                        num.append("\n");
                }
                num.append("\n");
            }

            int sum = Arrays.stream(num.toString().split("\n"))
                    .filter(s -> !Objects.equals(s, ""))
                    .mapToInt(Integer::parseInt)
                    .sum();
            max = Math.max(max, sum);
        }

        return String.valueOf(max);
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