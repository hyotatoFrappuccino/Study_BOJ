import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P14502 {
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
            matrix[i] = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        max = 0;
    }

    static String process() {
        dfs(0);

        return String.valueOf(max);
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            max = Math.max(max, calSafeZone(deepCopyIntMatrix(matrix)));
            return;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                    dfs(depth + 1);
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static int calSafeZone(int[][] zone) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (zone[i][j] == 2)
                    virus(i, j, zone);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (zone[i][j] == 0)
                    count++;
            }
        }
        return count;
    }

    public static void virus(int i, int j, int[][] zone) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            // 범위를 벗어나지 않도록 확인
            if (ni >= 0 && ni < N && nj >= 0 && nj < M && zone[ni][nj] == 0) {
                zone[ni][nj] = 2;
                virus(ni, nj, zone);
            }
        }

    }

    public static int[][] deepCopyIntMatrix(int[][] input) {
        if (input == null)
            return null;
        int[][] result = new int[input.length][];
        for (int r = 0; r < input.length; r++) {
            result[r] = input[r].clone();
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