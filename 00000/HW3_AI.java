import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HW3_AI {
    static char[][] matrix;
    static boolean[][] visited;
    static int n, m;
    static int min = Integer.MAX_VALUE;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = br.readLine().toCharArray();
        }
        bfs(0, 0, 1);
        System.out.println(min);
    }

    public static void bfs(int row, int column, int count) {
        if (row == (n - 1) && column == (m - 1)) {
            min = Math.min(min, count);
            return;
        }
        if (row < 0 || column < 0 || row > n - 1 || column > m - 1) {
            return;
        }
        if (matrix[row][column] == '1' && !visited[row][column]){
            visited[row][column] = true;
            count++;
            for (int i = 0; i < 4; i++) {
                bfs(row + dx[i], column + dy[i], count);
            }
            visited[row][column] = false;
        }
    }
}
