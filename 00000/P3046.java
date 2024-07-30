import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P3046 {
    static StringBuilder output;
    static int R1;
    static int S;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        R1 = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        output = new StringBuilder();
    }

    static String process() {
        return String.valueOf(S * 2 - R1);
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