import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2529 {
    static int N;
    static char[] list;
    static long min;
    static long max;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = new char[N + 1];
        StringTokenizer st = new StringTokenizer(lines[1]);
        for (int i = 0; i < N; i++) {
            list[i] = st.nextToken().charAt(0);
        }
        min = Long.MAX_VALUE;
        max = 0;
    }

    static String process() {
        dfs(0, new int[N + 1], new boolean[10]);
        String s = String.valueOf(min);
        if (s.length() == N) {
            s = "0" + s;
        }
        return max + "\n" + s;
    }

    static void dfs(int depth, int[] result, boolean[] visited) {
        if (depth == N + 1) {
            if (isValid(result, N + 1)) {
                long num = calNum(result);
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                if (isValid(result, depth)) {
                    dfs(depth + 1, result, visited);
                }
                visited[i] = false;
            }
        }
    }

    private static Long calNum(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            String str = Integer.toString(i);
            sb.append(str);
        }
        return Long.parseLong(sb.toString());
    }

    private static boolean isValid(int[] result, int depth) {
        for (int i = 1; i < depth; i++) {
            if (list[i-1] == '<') {
                if (result[i - 1] >= result[i]) {
                    return false;
                }
            } else {
                if (result[i - 1] <= result[i]) {
                    return false;
                }
            }
        }
        return true;
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