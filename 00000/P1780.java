import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1780 {
    static int N;
    static int[][] matrix;
    static int[] output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        output = new int[]{0, 0, 0};
    }

    static String process() {
        search(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i : output) {
            sb.append(i).append("\n");
        }
        return sb.toString();
    }

    private static void search(int x, int y, int n) {
        boolean allMinusOne = true;
        boolean allZero = true;
        boolean allOne = true;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (matrix[i][j] != -1) allMinusOne = false;
                if (matrix[i][j] != 0)  allZero = false;
                if (matrix[i][j] != 1) allOne = false;
            }
        }

        if (allMinusOne) output[0]++;
        if (allZero) output[1]++;
        if (allOne) output[2]++;

        if (allMinusOne || allZero || allOne) {
            return;
        }

        // 9분할
        n /= 3;
        search(x, y, n);
        search(x, y + n, n);
        search(x, y + 2 * n, n);
        search(x + n, y, n);
        search(x + n, y + n, n);
        search(x + n, y + 2 * n, n);
        search(x + 2 * n, y, n);
        search(x + 2 * n, y + n, n);
        search(x + 2 * n, y + 2 * n, n);
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