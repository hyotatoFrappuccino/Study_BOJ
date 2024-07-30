import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P1697 {
    static Deque<int[]> queue;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        queue = new ArrayDeque<>();
        visited = new boolean[100000 + 1];

        bw.append(String.valueOf(bfs(N, K)));

        // process


        // output
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(int n, int k) {
        queue.offer(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int sec = cur[1];

            if (curX == k) {
                return sec;
            }

            for (int x : getNextPos(curX)) {
                if (x >= 0 && x <= 100000 && !visited[x]) {
                    queue.offer(new int[]{x, sec + 1});
                    visited[x] = true;
                }
            }
        }
        return -1;
    }

    private static int[] getNextPos(int n) {
        return new int[]{n + 1, n - 1, n * 2};
    }
}
