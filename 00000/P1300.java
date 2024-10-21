import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class P1300 {
    static long N;
    static long K;

    static void input(String[] lines) {
        N = Long.parseLong(lines[0]);
        K = Long.parseLong(lines[1]);
    }

    static String process() {
        long low = 1;
        long high = K;

        while (low < high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += min(mid / i, N);
            }

            if (count >= K) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return String.valueOf(low);
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