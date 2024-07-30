import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P1707 {
    static boolean[] visited;
    static boolean[] color;
    static Map<Integer, List<Integer>> map;
    static String result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 정점의 개수
            int V = Integer.parseInt(st.nextToken());
            // 간선의 개수
            int E = Integer.parseInt(st.nextToken());

            map = new HashMap<>();
            for (int i = 1; i <= V; i++) {
                map.put(i, new ArrayList<>());
            }
            while (E-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map.get(a).add(b);
                map.get(b).add(a);
            }

            visited = new boolean[V + 1];
            color = new boolean[V + 1];
            result = "YES";
            for (int i = 1; i <= V; i++) {
                if(!visited[i]) {
                    dfs(i, true);
                }
            }
            bw.append(result).append("\n");
        }


        // output
        bw.flush();

        br.close();
        bw.close();
    }

    static void dfs(int start, boolean curColor) {
        if (visited[start]) {
            if (color[start] == !curColor) {
                result = "NO";
            }
            return;
        }

        visited[start] = true;
        color[start] = curColor;


        for (int node : map.get(start)) {
            dfs(node, !curColor);
        }
    }
}
