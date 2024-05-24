import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int r;
    static int c;
    static int[][] matrix;
    static int count;
    static int len;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        len = (int) Math.pow(2, N);
        matrix = new int[len][len];
    }

    static String process() {
        search(0, 0, (int) Math.pow(2, N), 0);
        return String.valueOf(matrix[r][c]);
    }

    private static void search(int x, int y, int N, int val) {
        if (N == 2) {
            matrix[x][y] = val++;
            matrix[x][y + 1] = val++;
            matrix[x + 1][y] = val++;
            matrix[x + 1][y + 1] = val;
            return;
        }

        N /= 2;
        if (r < (x + N) && c < (y + N)) {
            search(x, y, N, val);
        } else if (r >= (x + N) && c < (y + N)) {
            search(x, y + N, N, val + (int) Math.pow(2, N));
        } else if (r < (x + N) && c >= (y + N)) {
            search(x + N, y, N, val + (int) Math.pow(2, N) * 2);
        } else {
            search(x + N, y + N, N, val + (int) Math.pow(2, N) * 3);
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