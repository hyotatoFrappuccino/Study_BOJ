import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14929 {
    static int N;
    static long[] X;
    static long result;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        StringTokenizer st = new StringTokenizer(lines[1]);
        X = new long[N];
        for (int i = 0; i < N; i++) {
            X[i] = Long.parseLong(st.nextToken());
        }
    }

    static String process() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                result += X[i] * X[j];
            }
        }

        return String.valueOf(result);
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