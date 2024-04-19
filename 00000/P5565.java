import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P5565 {
    static int[] price;

    static void input(String[] lines) {
        price = new int[10];
        for (int i = 0; i < 10; i++) {
            price[i] = Integer.parseInt(lines[i]);
        }
    }

    static String process() {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += price[i];
        }
        return String.valueOf(price[0] - sum);
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