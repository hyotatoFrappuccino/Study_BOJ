import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P21736 {
    static int N;
    static int M;
    static int X; //도연이의 처음 위치
    static int Y; //도연이의 처음 위치
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;
    static int visit;
    static char[][] matrix;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] charArray = lines[i + 1].toCharArray();
            for (int j = 0; j < M; j++) {
                char c = charArray[j];
                matrix[i][j] = c;
                if (c == 'I') {
                    X = i;
                    Y = j;
                }
            }
        }

        visited = new boolean[N][M];
        visit = 0;
    }

    static String process() {
        dfs(X, Y);

        if (visit != 0) {
            return String.valueOf(visit);
        } else {
            return "TT";
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        // 사람을 만난 경우
        if (matrix[x][y] == 'P') {
            visit++;
        }

        // 다음으로
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];

            if (isValidPos(newX, newY) && !visited[newX][newY] &&
                    (matrix[newX][newY] == 'O' || matrix[newX][newY] == 'P')) {
                dfs(newX, newY);
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