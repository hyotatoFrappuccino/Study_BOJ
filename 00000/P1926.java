import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1926 {
    static int[][] matrix;
    static boolean[][] visited;
    static int size;
    static int n, m;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                size = 0;
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    count++;
                    bfs(i, j);
                    max = Math.max(max, size);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    public static void bfs(int row, int column) {
        if (row > n - 1 || column > m - 1 ||row < 0 || column < 0)
            return;
        if (matrix[row][column] == 1 && !visited[row][column]) {
            visited[row][column] = true;
            size++;
            for (int i = 0; i < 4; i++) {
                bfs(row + dx[i], column + dy[i]);
            }
        }
    }
}
