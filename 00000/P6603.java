import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P6603 {
    static String[] input;
    static int K;
    static int[] list;
    static int[] result;
    static boolean[] visited;
    static StringBuilder output;

    static void input(String[] lines) {
        input = lines;
        output = new StringBuilder();
    }

    static String process() {
        for (String s : input) {
            if (s != null && !s.equals("0")) {
                StringTokenizer st = new StringTokenizer(s);
                K = Integer.parseInt(st.nextToken());
                list = new int[K];
                result = new int[6];
                visited = new boolean[K];
                for (int j = 0; j < K; j++) {
                    list[j] = Integer.parseInt(st.nextToken());
                }
                dfs(0);
                output.append("\n");
            }
        }
        return output.toString();
    }

    static void dfs(int depth) {
        if (depth == 6) {
            for (int i : result) {
                output.append(i).append(" ");
            }
            output.append("\n");
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                if (depth > 0 && result[depth - 1] > list[i]) continue;
                visited[i] = true;
                result[depth] = list[i];
                dfs(depth + 1);
                visited[i] = false;
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