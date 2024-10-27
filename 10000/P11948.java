import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P11948 {
    static int A, B, C, D, E, F;

    static void input(String[] lines) {
        A = Integer.parseInt(lines[0]);
        B = Integer.parseInt(lines[1]);
        C = Integer.parseInt(lines[2]);
        D = Integer.parseInt(lines[3]);
        E = Integer.parseInt(lines[4]);
        F = Integer.parseInt(lines[5]);
    }

    static String process() {
        int max = 0;
        max = Math.max(max, A + B + C + E);
        max = Math.max(max, A + B + D + E);
        max = Math.max(max, A + C + D + E);
        max = Math.max(max, B + C + D + E);

        max = Math.max(max, A + B + C + F);
        max = Math.max(max, A + B + D + F);
        max = Math.max(max, A + C + D + F);
        max = Math.max(max, B + C + D + F);

        return String.valueOf(max);
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