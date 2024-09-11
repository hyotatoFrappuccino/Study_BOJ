import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P2110 {
    static int N;
    static int C;
    static int[] X;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(lines[i + 1]);
        }
        Arrays.sort(X);
    }

    static String process() {
        int low = 1;
        int high = X[N - 1] - X[0] + 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            boolean possible = check(mid);

            if (possible) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return String.valueOf(high);
    }

    private static boolean check(int gap) {
        int count = 1;
        int gapSum = 0;
        int lastX = X[0];

        for (int i = 1; i < N; i++) {
            gapSum += X[i] - lastX;
            lastX = X[i];

            if (gapSum >= gap) {
                gapSum = 0;
                count++;
            }
        }

        return count >= C;
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