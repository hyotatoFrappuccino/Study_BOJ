import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P31654 {
    static String input;


    static void input(String[] lines) {
        input = lines[0];
    }

    static String process() {
        int[] list = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        int A = list[0];
        int B = list[1];
        int C = list[2];

        if (A + B == C)
            return "correct!";
        else
            return "wrong!";
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