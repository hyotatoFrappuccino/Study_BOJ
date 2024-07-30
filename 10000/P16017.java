import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P16017 {
    static int[] number;

    static void input(String[] lines) {
        number = new int[4];
        for (int i = 0; i < 4; i++) {
            number[i] = Integer.parseInt(lines[i]);
        }
    }

    static String process() {
        boolean isTelemarketer = (number[0] == 8 || number[0] == 9) &&
                (number[3] == 8 || number[3] == 9) &&
                (number[1] == number[2]);

        if (isTelemarketer) {
            return "ignore";
        } else {
            return "answer";
        }
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