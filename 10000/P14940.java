import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14940 {
    static int N;
    static int M;
    static int startX;
    static int startY;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(lines[i + 1]);
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        output = new StringBuilder();
    }

    static String process() {
        bfs(startX, startY);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    result[i][j] = -1;
                }
                output.append(result[i][j]).append(" ");
            }
            output.append("\n");
        }

        return output.toString();
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});

        visited = new boolean[N][M];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            visited[x][y] = true;

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (isValidPos(newX, newY) && !visited[newX][newY] && map[newX][newY] == 1) {
                    q.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    result[newX][newY] = result[x][y] + 1;
                }
            }
        }
    }

    private static boolean isValidPos(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
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