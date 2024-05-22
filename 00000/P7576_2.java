import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7576_2 {
    static int M;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] matrix;
    static boolean[][] visited;
    static boolean change;
    static Deque<int[]> deque;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visited = new boolean[N][M];
        deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                int item = input[j];
                matrix[i][j] = item;
                if (item == 1) {
                    deque.add(new int[]{i, j});
                }
            }
        }
    }

    static String process() {

        int day = 0;
        while (!deque.isEmpty()) {
            change = false;
            int[] xy = deque.poll();
            int x = xy[0];
            int y = xy[1];
            bfs(x, y);
        }
        return String.valueOf(day);
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;
        Deque<int[]> tempDeque = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = x + dy[i];
            if (xx >= 0 && xx < N && yy >= 0 && yy < M && matrix[xx][yy] == 0)  {
                matrix[xx][yy] = 1;
                tempDeque.add(new int[]{xx, yy});
                change = true;
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