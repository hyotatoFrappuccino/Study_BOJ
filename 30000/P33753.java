import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P33753 {
    static int A, B, C, T;

    static void input(String[] lines) {
        String[] s = lines[0].split(" ");
        A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);
        C = Integer.parseInt(s[2]);

        T = Integer.parseInt(lines[1]);
    }

    static String process() {
        int result;
        if (T <= 30) {
            result = A;
        } else {
            result = A +    (int) Math.ceil((double) (T - 30) / B) * C;
        }

        return String.valueOf(result);
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