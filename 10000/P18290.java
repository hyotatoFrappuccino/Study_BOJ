import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P18290 {
    static int[][] matrix;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("DuplicatedCode")
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(new Point[K],0, K);
        bw.append(String.valueOf(max));

        bw.flush();

        bw.close();
        br.close();
    }

    /**
     * @param result 결과 좌표(현재 포함된 좌표)
     * @param depth 현재 깊이 (... K)
     * @param maxDepth 최대 깊이 (K)
     */
    public static void dfs(Point[] result, int depth, int maxDepth) {
        if (depth == maxDepth) {
//            System.out.println("result = " + Arrays.toString(result));
            int sum = 0;
            for (Point point : result) {
                sum += matrix[point.getX()][point.getY()];
            }
//            System.out.println("sum = " + sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!isAdjacent(result, i, j)) {
                    result[depth] = new Point(i, j);
                    dfs(result,depth + 1, maxDepth);
                    result[depth] = null;
                }
            }
        }
    }

    public static boolean isAdjacent(Point[] result, int x, int y) {
        for (Point point : result) {
            if (point != null) {
                int pointX = point.getX();
                int pointY = point.getY();
                if (pointX == x - 1 && pointY == y
                        || pointX == x + 1 && pointY == y
                        || pointX == x && pointY == y + 1
                        || pointX == x && pointY == y - 1
                        || pointX == x && pointY == y)
                    return true;
            }
        }
        return false;
    }
}

