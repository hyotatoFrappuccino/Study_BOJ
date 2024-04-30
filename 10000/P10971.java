import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P10971 {
    static int N;
    static int[][] matrix;
    static int[] list;
    static boolean[] visited;
    static int min;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        list = new int[N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;
    }

    static String process() {
        dfs(0);
        return String.valueOf(min);
    }

    static void dfs(int depth) {
        if (depth == N) {
            min = Math.min(min, calDistance());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    static int calDistance() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            int distance = matrix[list[i]][list[i + 1]];
            if (distance == 0) return Integer.MAX_VALUE;
            sum += distance;
        }
        if (matrix[list[N - 1]][list[0]] == 0) return Integer.MAX_VALUE;
        sum += matrix[list[N - 1]][list[0]];
        return sum;
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