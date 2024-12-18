import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P14651 {
    static int N;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
    }

    static String process() {
        if (N == 1) {
            return "0";
        }

        long num = 2;
        for (int i = 3; i <= N; i++) {
            num = (num * 3) % 1_000_000_009;
        }

        return String.valueOf(num);
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