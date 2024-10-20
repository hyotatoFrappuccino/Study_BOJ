import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P32498 {
    static int N;
    static int[] list;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(lines[i + 1]);
        }
    }

    static String process() {
        int count = 0;
        for (int num : list) {
            if ((num & 1) == 1) {
                count++;
            }
        }

        return String.valueOf(count);
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