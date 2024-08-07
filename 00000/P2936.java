import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2936 {
    static int x;
    static int y;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        output = new StringBuilder();
    }

    static String process() {
        double area = 250.0 * 250.0 / 2;
        if (x == 0 && y == 0) {
            output.append("125.00 125.00");
        } else if (x > 0 && y > 0) {
            output.append(String.format(x > y ? "0.00 %.2f" : "%.2f 0.00", 250.0 - area / Math.max(x, y)));
        } else if (x < 125 && y == 0) {
            double t = 250.0 - area / (250.0 - x);
            output.append(String.format("%.2f %.2f", t, 250.0 - t));
        } else if (x == 0 && y < 125) {
            double t = 250.0 - area / (250.0 - y);
            output.append(String.format("%.2f %.2f", 250.0 - t, t));
        } else if (x >= 125 && y == 0) {
            output.append(String.format("0.00 %.2f", area / x));
        } else if (x == 0 & y >= 125) {
            output.append(String.format("%.2f 0.00", area / y));
        }
        return output.toString().split("\n")[0];
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