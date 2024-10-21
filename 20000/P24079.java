import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P24079 {
    static int X;
    static int Y;
    static int Z;

    static void input(String[] lines) {
        X = Integer.parseInt(lines[0]);
        Y = Integer.parseInt(lines[1]);
        Z = Integer.parseInt(lines[2]);
    }

    static String process() {
        int time = X + Y;
        return time <= Z ? "1" : "0";
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