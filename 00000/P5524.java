import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P5524 {
    static int N;
    static String[] list;
    static StringBuilder output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = new String[N];
        for (int i = 0; i < N; i++) {
            list[i] = lines[i + 1];
        }
        output = new StringBuilder();
    }

    static String process() {
        for (String s : list) {
            for (char c : s.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    output.append((char) (c + 32));
                } else {
                    output.append(c);
                }
            }
            output.append("\n");
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