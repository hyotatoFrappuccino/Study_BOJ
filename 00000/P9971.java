import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P9971 {
    static StringBuilder output;
    static List<String> ciphers;

    static void input(String[] lines) {
        int idx = 1;
        ciphers = new ArrayList<>();
        while (true) {
            String input = lines[idx];
            ciphers.add(input);
            idx += 3;
            if (lines[idx - 1].equals("ENDOFINPUT")) break;
        }
        output = new StringBuilder();
    }

    static String process() {
        for (String cipher : ciphers) {
            for (char c : cipher.toCharArray()) {
                if (c >= 'F' && c <= 'Z') {
                    output.append((char) (c - 5));
                } else if (c >= 'A' && c <= 'E') {
                    output.append((char) (c + 21));
                }
                else {
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