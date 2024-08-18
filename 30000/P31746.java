import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P31746 {
    static int reverseNum;
    static int[] list;
    static StringBuilder output;

    static void input(String[] lines) {
        reverseNum = Integer.parseInt(lines[0]);
        output = new StringBuilder();
    }

    static String process() {
        if ((reverseNum & 1) == 1) {
            output.append("evoLmoCicS");
        } else {
            output.append("SciComLove");
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