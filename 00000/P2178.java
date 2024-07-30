import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2178 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] matrix;
    static boolean[][] visited;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = lines[i + 1].toCharArray();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = input[j] - '0';
            }
        }
        visited = new boolean[N][M];
    }

    static String process() {
        return String.valueOf(bfs(0, 0));
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 1});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int move = current[2];

            if (x == N - 1 && y == M - 1) {
                return move;
            }

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if (xx >= 0 && xx < N && yy >= 0 && yy < M && matrix[xx][yy] == 1 && !visited[xx][yy]) {
                    visited[xx][yy] = true;
                    queue.add(new int[]{xx, yy, move + 1});
                }
            }
        }
        return -1; // 경로가 없는 경우
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