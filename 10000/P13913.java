import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P13913 {
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

        Stack<Integer> stack = new Stack<>();
        stack.add(K);
        int idx = K;

        while (idx != N) {
            stack.push(parent[idx]);
            idx = parent[idx];
        }

        bw.append(String.valueOf(time[K] - 1)).append("\n");
        while (!stack.isEmpty()) {
            bw.append(String.valueOf(stack.pop())).append(" ");
        }

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

            for (int x : getNextPos(cur)) {
                if (x >= 0 && x <= 100000 && time[x] == 0) {
                    queue.offer(x);
                    // x에 도달했을 때 "시간"
                    time[x] = time[cur] + 1;
                    // x로 이도하기 직전 "위치"
                    parent[x] = cur;
                }
            }
        }
    }

    private static int[] getNextPos(int n) {
        return new int[]{n + 1, n - 1, n * 2};
    }
}
