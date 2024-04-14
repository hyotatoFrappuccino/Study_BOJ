import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1107 {
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        // process
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        List<Integer> possibleButton = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (!broken[i]) possibleButton.add(i);
        }

        if (N == 100) {
            bw.append("0");
            bw.flush();
            System.exit(0);
        } else {
            remocon(String.valueOf(N).length(), possibleButton);
            remocon(String.valueOf(N).length() + 1, possibleButton);
            if (String.valueOf(N).length() > 1)
                remocon(String.valueOf(N).length() - 1, possibleButton);
        }

        min = Math.min(min, Math.abs(100 - N));
        bw.append(String.valueOf(min));




        // output
        bw.flush();

        br.close();
        bw.close();
    }

    public static void dfs(int[] channel, int depth, int maxDepth, List<Integer> possibleButton) {
        if (depth == maxDepth) {
            StringBuilder sb = new StringBuilder();
            for (int i : channel) {
                sb.append(i);
            }
            int ch = Integer.parseInt(sb.toString());
            min = Math.min(min, maxDepth + Math.abs(N - ch));
            return;
        }

        for (int num : possibleButton) {
            channel[depth] = num;
            dfs(channel, depth + 1, maxDepth, possibleButton);
        }
    }

    public static void remocon(int maxDepth, List<Integer> possibleButton) {
        int[] channel = new int[maxDepth];
        dfs(channel, 0, maxDepth, possibleButton);
    }
}
