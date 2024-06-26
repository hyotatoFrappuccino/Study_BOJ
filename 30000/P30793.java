import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P30793 {
    static int p;
    static int r;

    static void input(String[] lines) {
        String[] s = lines[0].split(" ");
        p = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
    }

    static String process() {
        double v = (double) p / r;
        if (v < 0.2) {
            return "weak";
        } else if (v < 0.4) {
            return "normal";
        } else if (v < 0.6) {
            return "strong";
        } else {
            return "very strong";
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