import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P20528 {
    static StringBuilder output;
    static int N;
    static String[] list;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = lines[1].split(" ");
        output = new StringBuilder();
    }

    static String process() {
        boolean result = true;
        char end = list[0].charAt(list[0].length() - 1);
        for (int i = 1; i < list.length; i++) {
            if (list[i].charAt(0) != end) {
                result = false;
                break;
            }
            end = list[i].charAt(list[i].length() - 1);
        }

        if (result) {
            output.append("1");
        } else {
            output.append("0");
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