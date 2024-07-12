import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> input;
    static StringBuilder output;

    static void input(String[] lines) {
        int idx = 0;
        input = new ArrayList<>();
        while (true) {
            int N = Integer.parseInt(lines[idx++]);
            if (N == 0) break;
            StringTokenizer st = new StringTokenizer(lines[idx++]);
            List<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            input.add(list);
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < input.size(); i++) {
            output.append("case " + (i + 1) + ": " iter(input.get(i)));
        }

        return output.toString();
    }

    static String iter(List<Integer> list) {
        return "";
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