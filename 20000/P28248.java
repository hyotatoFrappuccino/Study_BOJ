import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P28248 {
    static int P;
    static int C;

    static void input(String[] lines) {
        P = Integer.parseInt(lines[0]);
        C = Integer.parseInt(lines[1]);
    }

    static String process() {
        int score = 0;
        int success = P * 50;
        int fail = C * 10;
        score += success;
        score -= fail;

        if (P > C) {
            score += 500;
        }

        return String.valueOf(score);
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