import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P27310 {
    static String input;

    static void input(String[] lines) {
        input = lines[0];
    }

    static String process() {
        char[] list = input.toCharArray();
        int sum = 0;
        sum += list.length;
        for (char c : list) {
            if (c == ':') {
                sum++;
            } else if (c == '_') {
                sum += 5;
            }
        }
        return String.valueOf(sum);
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