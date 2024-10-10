import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2502 {
    static int D, K;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static String process() {
        int[] dpOne = new int[D + 3];
        int[] dpTwo = new int[D + 3];
        dpOne[3] = dpOne[4] = dpTwo[3] = 1;
        dpTwo[4] = 2;

        for (int i = 5; i <= D; i++) {
            dpOne[i] = dpOne[i - 2] + dpOne[i - 1];
            dpTwo[i] = dpTwo[i - 2] + dpTwo[i - 1];
        }

        for (int i = 1; i <= K; i++) {
            int A = i * dpOne[D];
            int B = (K - A) / dpTwo[D];
            if (i * dpOne[D] + B * dpTwo[D] == K) {
                return i + "\n" + B;
            }
        }

        return "";

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