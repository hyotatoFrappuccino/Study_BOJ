import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P3036 {
    static int N;
    static int[] list;
    static StringBuilder output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = new int[N];
        StringTokenizer st = new StringTokenizer(lines[1]);
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 1; i < list.length; i++) {
            output.append(simpliy(list[0], list[i])).append("\n");
        }

        return output.toString();
    }

    static String simpliy(int numerator, int denominator) {
        int min = Math.min(numerator, denominator);
        int div = 0;
        for (int i = min; i >= 1; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                div = i;
                break;
            }
        }

        return "%d/%d".formatted(numerator / div, denominator / div);
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