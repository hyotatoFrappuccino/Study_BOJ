import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11724 {
    static int N;
    static int M;
    static Map<Integer, List<Integer>> map;
    static boolean[] visited;
    static int result;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(lines[i]);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        result = 0;
    }

    static String process() {
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) result++;
            dfs(i);
        }

        return String.valueOf(result);
    }

    static void dfs(int start) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;
        for (int node : map.get(start)) {
            if (!visited[node]) {
                dfs(node);
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