import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P25238 {
    static StringBuilder output;
    static float a;
    static float b;

    static void input(String[] lines) {
        String[] s = lines[0].split(" ");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        output = new StringBuilder();
    }

    static String process() {
        if (a - a * (b / 100) >= 100) {
            output.append("0");
        } else {
            output.append("1");
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