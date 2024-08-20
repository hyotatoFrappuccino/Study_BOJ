import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1931 {
    static int N;

    static Elem[] list;
    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);

        list = new Elem[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(lines[i + 1]);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[i] = new Elem(start, end);
        }


    }

    static String process() {
        Arrays.sort(list);
        int result = 1;
        int end = list[0].getEnd();

        for (int i = 1; i < N; i++) {
            if (list[i].getStart() >= end) {
                end = list[i].getEnd();
                result++;
            }
        }

        return String.valueOf(result);
    }

    static class Elem implements Comparable<Elem> {
        private final int start;
        private final int end;

        public Elem(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Elem o) {
            int comp = this.getEnd() - o.getEnd();
            if (comp == 0) {
                return this.getStart() - o.getStart();
            } else {
                return comp;
            }
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