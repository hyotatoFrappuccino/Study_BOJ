import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P30868 {
    static StringBuilder output;
    static int T;
    static int[] N;

    static void input(String[] lines) {
        T = Integer.parseInt(lines[0]);
        N = new int[T];
        for (int i = 0; i < T; i++) {
            N[i] = Integer.parseInt(lines[i + 1]);
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < T; i++) {
            output.append("++++ ".repeat(N[i] / 5)).append("|".repeat(N[i] % 5)).append("\n");
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