import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P9295 {
    static int T;
    static int[] A;
    static int[] B;
    static StringBuilder output;

    static void input(String[] lines) {
        T = Integer.parseInt(lines[0]);
        A = new int[T];
        B = new int[T];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(lines[i + 1]);
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < T; i++) {
            output.append("Case %d: %d".formatted(i + 1, A[i] + B[i])).append("\n");
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