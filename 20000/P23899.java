import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P23899 {
    static StringBuilder output;
    static int N;
    static long[] A;
    static long[] B;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        A = Arrays.stream(lines[1].split(" ")).mapToLong(Long::parseLong).toArray();
        B = Arrays.stream(lines[2].split(" ")).mapToLong(Long::parseLong).toArray();
        output = new StringBuilder();
    }

    static String process() {
        boolean result = false;
        for (int last = N - 1; last > 0; last--) {
            if (Arrays.equals(A, B)) {
                result = true;
                break;
            }

            long max = A[0];
            int maxIndex = 0;
            for (int i = 0; i <= last; i++) {
                if (A[i] > max) {
                    max = A[i];
                    maxIndex = i;
                }
            }

            if (last != maxIndex) {
                A[maxIndex] = A[last];
                A[last] = max;
            }
        }
        if (Arrays.equals(A, B)) {
            result = true;
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