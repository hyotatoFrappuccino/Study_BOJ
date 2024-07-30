import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1074 {
    static int N;
    static int r;
    static int c;
    static int len;
    static int output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        len = (int) Math.pow(2, N);
    }

    static String process() {
        search(0, 0, N, 0);
        return String.valueOf(output);
    }

    private static void search(int x, int y, int N, int val) {
        if (N == 1) {
            if (x == r && y == c) {
                output = val;
                return;
            }
            val++;

            if (x == r && y + 1 == c) {
                output = val;
                return;
            }
            val++;

            if (x + 1 == r && y == c) {
                output = val;
                return;
            }
            val++;

            if (x + 1 == r && y + 1 == c) {
                output = val;
                return;
            }
            return;
        }

        int add = (int) Math.pow(4, N - 1);
        int range = (int) Math.pow(2, N - 1);
        if (r < (x + range) && c < (y + range)) {
            search(x, y, N - 1, val);
        } else if (r >= (x + range) && c < (y + range)) {
            search(x + range, y, N - 1, val + add * 2);
        } else if (r < (x + range) && c >= (y + range)) {
            search(x, y + range, N - 1, val + add);
        } else {
            search(x + range, y + range, N - 1, val + add * 3);
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