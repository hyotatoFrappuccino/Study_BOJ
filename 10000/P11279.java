import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P11279 {
    static int N;
    static int[] list;
    static PriorityQueue<Integer> q;
    static StringBuilder output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = new int[N];
        q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(lines[i + 1]);
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i : list) {
            if (i != 0) {
                q.add(i);
            } else {
                if (!q.isEmpty()) {
                    output.append(q.poll()).append("\n");
                } else {
                    output.append("0").append("\n");
                }
            }
        }

        return output.toString();
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