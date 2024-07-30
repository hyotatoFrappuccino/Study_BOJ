import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P10974 {
    static StringBuilder output;
    static int N;
    static int[] list;
    static boolean[] visited;


    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        visited = new boolean[N];
        list = new int[N];
        output = new StringBuilder();
    }

    static String process() {
        dfs(0);
        return output.toString();
    }

    static void dfs(int depth) {
        if (depth == N) {
            for (int n : list) {
                output.append(n).append(" ");
            }
            output.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i - 1]) {
                list[depth] = i;
                visited[i - 1] = true;
                dfs(depth + 1);
                visited[i - 1] = false;
            }
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