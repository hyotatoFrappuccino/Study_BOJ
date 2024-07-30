import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P26561 {
    static int testcase;
    static String[] input;
    static StringBuilder output;

    static void input(String[] lines) {
        testcase = Integer.parseInt(lines[0]);
        input = new String[lines.length - 1];
        System.arraycopy(lines, 1, input, 0, input.length);
        output = new StringBuilder();
    }

    static String process() {
        for (String s : input) {
            int[] list = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int p = list[0];
            int t = list[1];
            p += t / 4;
            p -= t / 7;
            output.append(p).append("\n");
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