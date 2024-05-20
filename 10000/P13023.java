import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P13023 {
    static int N;
    static int M;
    static Map<Integer, List<Integer>> map;
    static boolean[] visited;
    static boolean found;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(lines[i]);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        visited = new boolean[N];
        found = false;
    }

    static String process() {
        for (int i = 0; i < N; i++) {
            if (!found) {
                visited[i] = true;
                DFS(i, 1);
                visited[i] = false;
            }
        }

        return found ? "1" : "0";
    }

    static void DFS(int node, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }

        List<Integer> list = map.get(node);
        if (list != null) {
            for (int neighbor : list) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    DFS(neighbor, depth + 1);
                    visited[neighbor] = false;
                    if (found) return;  // 조기 종료
                }
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
