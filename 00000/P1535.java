import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1535 {
    static int N;
    static int[] L;
    static int[] J;
    static int max;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);

        L = new int[N];
        J = new int[N];
        max = 0;
        StringTokenizer st = new StringTokenizer(lines[1]);
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(lines[2]);
        for (int i = 0; i < N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }
    }

    static String process() {
        func(100, 1, 0);
        return String.valueOf(max);
    }

    private static void func(int h, int idx, int e) {
        if (h <= 0) {
            return;
        }
        if (idx == N && h - L[N - 1] > 0) {
            max = Math.max(max, e + J[N - 1]);
            return;
        }
        if (idx == N) {
            max = Math.max(max, e);
            return;
        }

        func(h - L[idx - 1], idx + 1, e + J[idx - 1]);
        func(h, idx + 1, e);
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