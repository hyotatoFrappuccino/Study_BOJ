import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P10808 {
    static StringBuilder output;
    static String input;

    static void input(String[] lines) {
        output = new StringBuilder();
        input = lines[0];
    }

    static String process() {
        char[] list = input.toCharArray();
        int[] res = new int['z' - 'a' + 1];
        for (char c : list) {
            res[c - 'a'] += 1;
        }

        for (int re : res) {
            output.append(re).append(" ");
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