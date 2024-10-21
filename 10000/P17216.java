import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P17216 {
    static int N;
    static int[] list;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = new int[N];

        StringTokenizer st = new StringTokenizer(lines[1]);
        for (int i = N - 1; i >= 0; i--) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }

    static String process() {
        int[] dp = new int[N];
        int[] sum = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            sum[i] = list[i];
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    sum[i] = Math.max(sum[i], sum[j] + list[i]);
                }
            }
        }

        int max = 0;
        for (int i : sum) {
            max = Math.max(max, i);
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