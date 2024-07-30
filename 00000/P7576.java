import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7576 {
    static int M;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] matrix;
    static boolean[][] visited;
    static boolean change;
    static Deque<int[]> deque;
    static Deque<int[]> tempDeque;
    static int zeroCount;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visited = new boolean[N][M];
        deque = new ArrayDeque<>();
        zeroCount = 0;
        tempDeque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                int item = input[j];
                matrix[i][j] = item;
                if (item == 1) {
                    deque.add(new int[]{i, j});
                }
                if (item == 0) {
                    zeroCount++;
                }
            }
        }
    }

    static String process() {
        int day = 0;
        while (true) {
            change = false;
            while (!deque.isEmpty()) {
                int[] xy = deque.poll();
                int x = xy[0];
                int y = xy[1];
                bfs(x, y);

            }
            if (change) day++;
            else if (day == 0) {
                return zeroCount > 0 ? "-1" : "0";
            }
            else {
//                    모두 익지 못했다면
                if (zeroCount > 0) {
                    return "-1";
                }
                return String.valueOf(day);
            }
            deque = tempDeque;
            tempDeque = new ArrayDeque<>();
        }
    }

    private static void bfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && xx < N && yy >= 0 && yy < M && matrix[xx][yy] == 0 && !visited[xx][yy])  {
                matrix[xx][yy] = 1;
                tempDeque.add(new int[]{xx, yy});
                change = true;
                visited[xx][yy] = true;
                zeroCount--;
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