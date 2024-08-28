import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P19602 {
    static int S;
    static int M;
    static int L;

    static void input(String[] lines) {
        S = Integer.parseInt(lines[0]);
        M = Integer.parseInt(lines[1]);
        L = Integer.parseInt(lines[2]);
    }

    static String process() {
        return S + 2 * M + 3 * L >= 10 ? "happy" : "sad";
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