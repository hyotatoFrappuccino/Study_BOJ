import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P24444 {
    static int N;
    static int M;
    static int R;
    static List<List<Integer>> edges;
    static int count;
    static int[] visit;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(lines[i + 1]);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            edges.get(A).add(B);
            edges.get(B).add(A);
        }

        visit = new int[N + 1];
        count = 1;

        output = new StringBuilder();
    }

    static String process() {
        for (List<Integer> edge : edges) {
            edge.sort(Comparator.naturalOrder());
        }

        bfs();

        for (int i = 1; i < visit.length; i++) {
            output.append(visit[i]).append("\n");
        }

        return output.toString();
    }

    static void bfs() {
        boolean[] visited = new boolean[N + 1];
        visited[R] = true;
        visit[R] = count++;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : edges.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    visit[v] = count++;
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