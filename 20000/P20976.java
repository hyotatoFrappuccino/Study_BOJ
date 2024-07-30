import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P20976 {
    static int[] list;

    static void input(String[] lines) {
        list = new int[3];
        StringTokenizer st = new StringTokenizer(lines[0]);
        for (int i = 0; i < 3; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }

    static String process() {
        Arrays.sort(list);

        return String.valueOf(list[1]);
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