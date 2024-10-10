import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2302 {
    static int N, M;
    static boolean[] fixSeats;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        M = Integer.parseInt(lines[1]);
        fixSeats = new boolean[N];
        for (int i = 0; i < M; i++) {
            fixSeats[Integer.parseInt(lines[i + 2]) - 1] = true;
        }
    }

    static String process() {
        int[] fibo = new int[N + 1];
        fibo[0] = 1;
        fibo[1] = 2;
        for (int i = 2; i < N; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }

        int len = 0;
        int res = 1;
        for (int i = 0; i < N; i++) {
            if (fixSeats[i]) {
                if (len >= 1) {
                    res *= fibo[len - 1];
                }
                len = 0;
            } else {
                len++;
            }
        }
        if (!fixSeats[N - 1]) {
            res *= fibo[len - 1];
        }

        return String.valueOf(res);
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