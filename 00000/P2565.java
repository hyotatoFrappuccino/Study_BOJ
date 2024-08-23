import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2565 {
    static int N;
    static List<Integer> A;
    static int[] adj;
    static StringBuilder output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        A = new ArrayList<>();
        adj = new int[500 + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(lines[i + 1]);
            A.add(Integer.parseInt(st.nextToken()));
            adj[A.get(i)] = Integer.parseInt(st.nextToken());
        }
        output = new StringBuilder();
    }

    static String process() {
        A.sort(Comparator.naturalOrder());
        int[] lis = new int[500 + 1];
        int[] dp = new int[500 + 1];
        for (int i = 0; i < N; i++) {
            lis[i] = adj[A.get(i)];
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (lis[j] < lis[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return String.valueOf(N - Arrays.stream(dp).max().getAsInt());
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