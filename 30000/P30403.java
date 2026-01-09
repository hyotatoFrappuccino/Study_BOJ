import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P30403 {
    static StringBuilder output;
    static int N;
    static String str;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        str = lines[1];
        output = new StringBuilder();
    }

    static String process() {
        boolean possibleLowerCaseRainbow = false;
        boolean possibleUpperCaseRainbow = false;

        if (str.contains("r") && str.contains("o") && str.contains("y") && str.contains("g") && str.contains("b") && str.contains("i") && str.contains("v")) {
            possibleLowerCaseRainbow = true;
        }

        if (str.contains("R") && str.contains("O") && str.contains("Y") && str.contains("G") && str.contains("B") && str.contains("I") && str.contains("V")) {
            possibleUpperCaseRainbow = true;
        }

        if (possibleLowerCaseRainbow && possibleUpperCaseRainbow) {
            output.append("YeS");
        } else if (possibleLowerCaseRainbow) {
            output.append("yes");
        } else if (possibleUpperCaseRainbow) {
            output.append("YES");
        } else {
            output.append("NO!");
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