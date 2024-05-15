import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P5543 {
    static int[] list;

    static void input(String[] lines) {
        list = new int[5];
        for (int i = 0; i < 5; i++) {
            list[i] = Integer.parseInt(lines[i]);
        }
    }

    static String process() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int ham = list[i];
            min = Math.min(ham + list[3] - 50, min);
            min = Math.min(ham + list[4] - 50, min);
        }

        return String.valueOf(min);
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