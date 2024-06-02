import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2290 {
    static int s;
    static int[] n;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        s = Integer.parseInt(st.nextToken());
        n = st.nextToken().chars().map(Character::getNumericValue).toArray();
        output = new StringBuilder();
    }

    static String process() {
        for (int num : n) {
            output.append(" ");
            if (num == 2 || num == 3 || num == 5 || num == 6 || num == 7 || num == 8 || num == 9 || num == 0) {
                output.append("-".repeat(s));
            } else {
                output.append(" ".repeat(s));
            }
            output.append(" ");
            output.append(" ");
        }
        output.append("\n");

        StringBuilder sb = new StringBuilder();
        for (int num : n) {
            if (num == 4 || num == 5 || num == 6 || num == 8 || num == 9 || num == 0) {
                sb.append("|");
            } else {
                sb.append(" ");
            }
            sb.append(" ".repeat(s));
            if (num == 1 || num == 2 || num == 3 || num == 4 || num == 7 || num == 8 || num == 9 || num == 0) {
                sb.append("|");
            } else {
                sb.append(" ");
            }
            sb.append(" ");
        }
        for (int i = 0; i < s; i++) {
            output.append(sb);
            output.append("\n");
        }

        for (int num : n) {
            output.append(" ");
            if (num == 2 || num == 3 || num == 4 || num == 5 || num == 6 || num == 8 || num == 9) {
                output.append("-".repeat(s));
            } else {
                output.append(" ".repeat(s));
            }
            output.append(" ");
            output.append(" ");
        }
        output.append("\n");

        sb = new StringBuilder();
        for (int num : n) {
            if (num == 2 || num == 6 || num == 8 || num == 0) {
                sb.append("|");
            } else {
                sb.append(" ");
            }
            sb.append(" ".repeat(s));
            if (num == 1 || num == 3 || num == 4 || num == 5 || num == 6 || num == 7 || num == 8 || num == 9 || num == 0) {
                sb.append("|");
            } else {
                sb.append(" ");
            }
            sb.append(" ");
        }
        for (int i = 0; i < s; i++) {
            output.append(sb);
            output.append("\n");
        }

        for (int num : n) {
            output.append(" ");
            if (num == 2 || num == 3 || num == 5 || num == 6 || num == 8 || num == 9 || num == 0) {
                output.append("-".repeat(s));
            } else {
                output.append(" ".repeat(s));
            }
            output.append(" ");
            output.append(" ");
        }
        output.append("\n");



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