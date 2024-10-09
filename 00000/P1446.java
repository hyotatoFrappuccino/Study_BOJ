import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P1446 {
    static int N;
    static int D;
    static List<ShortCut> list;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(lines[i + 1]);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if (end <= D) {
                list.add(new ShortCut(start, end, length));
            }
        }
        Collections.sort(list);
    }

    static String process() {
        int[] dp = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            dp[i] = i;
        }

        for (ShortCut shortCut : list) {
            int start = shortCut.start;
            int end = shortCut.end;
            int length = shortCut.length;

            dp[end] = Math.min(dp[end], dp[start] + length);
            for (int i = end + 1; i <= D; i++) {
                dp[i] = dp[end] + i - end;
            }
        }

        return String.valueOf(dp[D]);
    }

    static final class ShortCut implements Comparable<ShortCut> {
        private final int start;
        private final int end;
        private final int length;

        ShortCut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
            public int compareTo(ShortCut o) {
                if (this.end() != o.end()) {
                    return this.end() - o.end();
                } else {
                    return this.start() - o.start();
                }
            }

        public int start() {
            return start;
        }

        public int end() {
            return end;
        }

        public int length() {
            return length;
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