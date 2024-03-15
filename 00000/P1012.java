import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            boolean[][] matrix = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[x][y] = true;
            }

            int result = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (matrix[j][k]) {
                        result++;
                        matrix[j][k] = false;
                        checkCabbage(matrix, j, k);
                    }
                }
            }

            System.out.println(result);
        }
    }

    public static void checkCabbage(boolean[][] matrix, int x, int y) {
        int M = matrix.length;
        int N = matrix[0].length;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && xx < M && yy >= 0 && yy < N && matrix[xx][yy]) {
                matrix[xx][yy] = false;
                checkCabbage(matrix, xx, yy);
            }
        }
    }
}
