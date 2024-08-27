import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P7595 {
    static int[] N;
    static StringBuilder output;

    static void input(String[] lines) {

        N = new int[lines.length - 1];
        for (int i = 0; i < lines.length - 1; i++) {
            N[i] = Integer.parseInt(lines[i]);
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i : N) {
            for (int j = 1; j <= i; j++) {
                output.append("*".repeat(j));
                output.append("\n");
            }
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