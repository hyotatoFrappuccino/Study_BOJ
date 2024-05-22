import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P7562 {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static boolean[][] visited;
    static BufferedWriter bw;
    static Deque<int[]> deque;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int desX = Integer.parseInt(st.nextToken());
            int desY = Integer.parseInt(st.nextToken());
            visited = new boolean[len][len];
            deque = new ArrayDeque<>();
            int move = bfs(curX, curY, desX, desY, len);
            bw.append(String.valueOf(move)).append("\n");
        }
        // output
        bw.flush();
        br.close();
        bw.close();
    }

    private static int bfs(int curX, int curY, int desX, int desY, int len) {
        deque.offer(new int[]{curX, curY});

        int move = 0;
        while (!deque.isEmpty()) {
            int lenDeque = deque.size();
            for (int r = 0; r < lenDeque; r++) {

                int[] list = deque.pollFirst();
                int nowX = list[0];
                int nowY = list[1];

                if (nowX == desX && nowY == desY) {
                    return move;
                }

//                visited[nowX][nowY] = true;

                for (int i = 0; i < dx.length; i++) {
                    int xx = nowX + dx[i];
                    int yy = nowY + dy[i];

                    if (xx >= 0 && xx < len && yy >= 0 && yy < len && !visited[xx][yy]) {
//                        System.out.println(xx + ", " + yy + ", " + move);
                        deque.offer(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
            move++;
        }
        return 0;
    }
}
