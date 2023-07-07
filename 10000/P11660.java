import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[][] input = new int[N][N];
        for (int i = 0; i < N; i++) {
            input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        long[][] sum = new long[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            sum[i][1] = sum[i-1][1] + input[i-1][0];
            sum[1][i] = sum[1][i-1] + input[0][i-1];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] + input[i-1][j-1] - sum[i-1][j-1];
            }
        }

        for (int i = 0; i < M; i++) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = xy[0];
            int y1 = xy[1];
            int x2 = xy[2];
            int y2 = xy[3];
            System.out.println(sum[x2][y2] - (sum[x1-1][y2] + sum[x2][y1-1] - sum[x1-1][y1-1]));
        }
    }
}
