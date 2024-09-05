import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P2805 {
    static int N; //나무의 수
    static long M; //가져가려는 나무의 길이
    static long[] height; //나무들의 높이

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        height = new long[N];
        st = new StringTokenizer(lines[1]);
        for (int i = 0; i < N; i++) {
            height[i] = Long.parseLong(st.nextToken());
        }
    }

    static String process() {
        long low = 0;
        long high = Arrays.stream(height).max().orElse(0);

        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = getSumOfCut(mid);

            if (sum < M) {
                high = mid - 1;
            } else if (sum > M) {
                low = mid + 1;
            } else {
                return String.valueOf(mid);
            }
        }
        return String.valueOf(high);
    }

    static long getSumOfCut(long H) {
        long sum = 0;
        for (long i : height) {
            long remain = i - H;
            if (remain > 0) {
                sum += remain;
            }
        }

        return sum;
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