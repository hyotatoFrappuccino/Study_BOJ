import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P8394 {
    static int N;
    static int res;
    static int A;
    static int B;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        A = 1;
        B = 2;
    }

    static String process() {
        if (N == 1) return "1";
        if (N == 2) return "2";
        for (int i = 3; i <= N; i++) {
            res = (A + B) % 10;
            A = B;
            B = res;
        }

        String s = String.valueOf(res);

        return String.valueOf(s.charAt(s.length() - 1));
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