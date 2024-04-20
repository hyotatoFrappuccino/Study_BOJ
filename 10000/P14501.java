import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14501 {
    static int N;
    static int[] T;
    static int[] P;
    static int max;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        T = new int[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(lines[i + 1]);
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        max = 0;
    }

    static String process() {
        dfs(new boolean[N], 0, N);
        return String.valueOf(max);
    }

    static void dfs(boolean[] result, int depth, int maxDepth) {

        if (depth == maxDepth) {
            max = Math.max(max, calMoney(result.clone()));
            return;
        }

        result[depth] = true;
        dfs(result, depth + 1, maxDepth);
        result[depth] = false;
        dfs(result, depth + 1, maxDepth);
    }

    private static int calMoney(boolean[] result) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (result[i]) {
                if (i + T[i] <= N) {
                    sum += P[i];
                    for (int j = i; j < i + T[i]; j++) {
                        result[j] = false;
                    }
                }
            }
        }
        return sum;
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