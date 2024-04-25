import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P3273 {
    static int N;
    static int[] list;
    static int x;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(list);
        x = Integer.parseInt(lines[2]);
    }

    static String process() {
        int start = 0;
        int end = N - 1;
        int count = 0;
        while (start < end) {
            int sum = list[start] + list[end];
            if (sum == x) {
                start++;
                end--;
                count++;
            } else if (sum > x) {
                end--;
            } else {
                start++;
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