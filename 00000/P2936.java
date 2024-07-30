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
        if (x == 0 || y == 0) {
            for (double res_x = 0; res_x <= 250; res_x += 0.01) {
                double res_y = 250 - res_x;
                calc(x, y, res_x, res_y, true);
            }
        } else {
            for (double res_x = 0; res_x <= 250; res_x += 0.01) {
                double res_y = 0;
                if (x > y) {
                    calc(x, y, res_y, res_x, true);
                } else {
                    calc(y, x, res_y, res_x, false);
                }
            }
        }
        return output.toString().split("\n")[0];
    }

    private static void calc(int x, int y, double res_x, double res_y, boolean format) {
        double a = 0;
        if (x == 0) {
            a = 250 - y;
        } else if (y == 0) {
            a = 250 - x;
        } else if (x >= y) {
            a = 250 - res_y;
        }
        double b = Math.sqrt(Math.pow(res_x - x, 2) + Math.pow(res_y - y, 2));
        double c = 0;
        if (x == 0) {
            c = Math.sqrt(Math.pow(res_x, 2) + Math.pow(res_y - 250, 2));
        } else if (y == 0) {
            c = Math.sqrt(Math.pow(res_x - 250, 2) + Math.pow(res_y, 2));
        } else if (x >= y) {
            c = Math.sqrt(Math.pow(x, 2) + Math.pow(y - 250, 2));
        }
        double p = (a + b + c) / 2;

        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        if (area >= 15625 && area < 15626) {
            if (format) {
                output.append(String.format("%.2f %.2f", res_x, res_y)).append("\n");
            } else {
                output.append(String.format("%.2f %.2f", res_y, res_x)).append("\n");
            }
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