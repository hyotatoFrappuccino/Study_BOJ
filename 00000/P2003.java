import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P2003 {
    static int N;
    static int M;
    static int[] list;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static String process() {
        int start = 0;
        int end = 0;
        int count = 0;

        while (start < N && end < N) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += list[i];
            }
            if (sum == M) {
                start += 1;
                end = start;
                count++;
            } else if (sum > M) {
                start += 1;
                end = start;
            } else {
                end++;
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