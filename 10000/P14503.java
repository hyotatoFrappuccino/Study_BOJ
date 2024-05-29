import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P14503 {
    static int N;
    static int M;
    static int r;
    static int c;
    static int direction;
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] matrix;

    static int result;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(lines[1]);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(lines[2 + i].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        result = 0;
    }

    static String process() {
        clean();
        return String.valueOf(result);
    }

    private static void clean() {
        while (true) {
            // 1. 현재 위치를 청소한다.
            if (matrix[r][c] == 0) {
                matrix[r][c] = -1;
                result++;
            }

            boolean moved = false;
            // 2. 현재 위치에서 네 방향을 탐색한다.
            for (int i = 0; i < 4; i++) {
                counterClockWiseRotate(); // 반시계 방향으로 회전
                int dx = r + directions[direction][0];
                int dy = c + directions[direction][1];
                if (isValidPos(dx, dy) && matrix[dx][dy] == 0) {
                    r = dx;
                    c = dy;
                    moved = true;
                    break;
                }
            }

            // 3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우
            if (!moved) {
                int dx = r - directions[direction][0];
                int dy = c - directions[direction][1];
                if (!isValidPos(dx, dy) || matrix[dx][dy] == 1) {
                    // 후진할 수 없으면 작동을 멈춘다.
                    break;
                }
                r = dx;
                c = dy;
            }
        }
    }

    private static void counterClockWiseRotate() {
        direction = (direction + 3) % 4; // 0 -> 3, 1 -> 0, 2 -> 1, 3 -> 2
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