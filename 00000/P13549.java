import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P13549 {
    static int[] time = new int[100000 + 1];
    static int[] parent = new int[100000 + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
        bw.append(String.valueOf(time[K] - 1));

        // output
        bw.flush();

        br.close();
        bw.close();

    }

    private static void bfs(int n, int k) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(n);
        time[n] = 1;


        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == k) return;

            int x = cur * 2;
            if (x >= 0 && x <= 100000 && time[x] == 0) {
                queue.offer(x);
                // x에 도달했을 때 "시간"
                time[x] = time[cur];
            }

            x = cur - 1;
            if (x >= 0 && x <= 100000 && time[x] == 0) {
                queue.offer(x);
                // x에 도달했을 때 "시간"
                time[x] = time[cur] + 1;
            }

            x = cur + 1;
            if (x >= 0 && x <= 100000 && time[x] == 0) {
                queue.offer(x);
                // x에 도달했을 때 "시간"
                time[x] = time[cur] + 1;
            }

        }
    }

    private static int[] getNextPos(int n) {
        return new int[]{n + 1, n - 1, n * 2};
    }
}
