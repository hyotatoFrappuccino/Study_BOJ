import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P19621 {
    static int N;
    static List<Data> list;
    static int lastEnd;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(lines[i + 1]);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lastEnd = Math.max(lastEnd, end);
            int people = Integer.parseInt(st.nextToken());
            Data data = new Data(start, end, people);
            list.add(data);
        }
        Collections.sort(list);
    }

    static String process() {
        int[] dp = new int[N + 2];
        dp[0] = list.get(0).getPeople();
        if (N > 1) {
            dp[1] = Math.max(dp[0], list.get(1).getPeople());
        }

        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + list.get(i).getPeople());
        }

        return String.valueOf(dp[N - 1]);
    }

    static class Data implements Comparable<Data> {
        private final int start;
        private final int end;
        private final int people;

        public Data(int start, int end, int people) {
            this.start = start;
            this.end = end;
            this.people = people;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getPeople() {
            return people;
        }

        @Override
        public int compareTo(Data o) {
            return this.getEnd() - o.getEnd();
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