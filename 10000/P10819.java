import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P10819 {
    static int N;
    static int[] input;
    static int[] list;
    static boolean[] visited;
    static int max;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        input = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        list = new int[N];
        visited = new boolean[N];
        max = 0;
    }

    static String process() {
        dfs(0);
        return String.valueOf(max);
    }

    static void dfs(int depth) {
        if (depth == N) {
            max = Math.max(max, cal());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                list[depth] = input[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    static int cal() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(list[i] - list[i + 1]);
        }
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