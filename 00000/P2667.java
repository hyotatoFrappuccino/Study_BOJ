import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P2667 {
    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static StringBuilder output;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    static int[] countComplexNum;
    static int complexNum;


    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        visited = new boolean[N][N];
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] input = lines[i + 1].toCharArray();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = input[j] - '0';
            }
        }
        countComplexNum = new int[N * N];
        complexNum = 1;
        output = new StringBuilder();
    }

    static String process() {
        search(0, 0);

        output.append(complexNum - 1).append("\n");
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < N * N; i++) {
            int count = countComplexNum[i];
            if (count > 0) list.add(count);
        }
        list.sort(Comparator.naturalOrder());
        for (Integer i : list) {
            if (i > 0) {
                output.append(i).append("\n");
            }
        }
        return output.toString();
    }

    static void search(int x, int y) {
        if (isValidPos(x, y)) {
            if (matrix[x][y] == 1 && !visited[x][y]) {
                setNum(x, y, complexNum);
                complexNum++;
            }

            if (y == N - 1)
                search(x + 1, 0);
            else
                search(x, y + 1);
        }
    }

    private static void setNum(int x, int y, int complexNum) {
        if (isValidPos(x, y) && !visited[x][y] && matrix[x][y] == 1) {
            visited[x][y] = true;
            matrix[x][y] = complexNum;
            incComplex(complexNum);
            for (int i = 0; i < 4; i++) {
                setNum(x + dx[i], y + dy[i], complexNum);
            }
        }
    }

    private static void incComplex(int complexNum) {
        countComplexNum[complexNum]++;
    }

    private static boolean isValidPos(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
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