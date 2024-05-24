import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1261 {
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N;
    static int M;
    static int[][] matrix;
    static boolean[][] visited;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] list = lines[i + 1].toCharArray();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = list[j] - '0';
            }
        }
        visited = new boolean[N][M];
    }

    static String process() {
        return String.valueOf(bfs());
    }

    private static int bfs() {
        Deque<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] item = q.poll();
            int x = item[0];
            int y = item[1];
            int count = item[2];

            if (x == N - 1 && y == M - 1) {
                return count;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (matrix[nx][ny] == 0) {
                        q.offerFirst(new int[]{nx, ny, count});
                    } else {
                        q.offer(new int[]{nx, ny, count + 1});
                    }
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
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