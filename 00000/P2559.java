import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2559 {
    static int N;
    static int K;
    static int[] list;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(lines[1]);
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }

    static String process() {
        int max;
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += list[i];
        }
        max = sum;

        for (int i = K; i < N; i++) {
            sum -= list[i - K];
            sum += list[i];
            max = Math.max(max, sum);
        }

        return String.valueOf(max);
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