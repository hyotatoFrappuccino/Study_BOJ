import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P15665 {
    static int N;
    static int M;
    static List<Integer> list;
    static List<String> result;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        st = new StringTokenizer(lines[1]);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        list.sort(Comparator.naturalOrder());
        result = new ArrayList<>();
        output = new StringBuilder();
    }

    static String process() {
        dfs(0, new int[M]);

        for (String s : result) {
            output.append(s).append("\n");
        }
        return output.toString();
    }

    static void dfs(int depth, int[] num) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : num) {
                sb.append(i).append(" ");
            }
//            if (!result.contains(sb.toString())) {
                result.add(sb.toString());
//            }
            return;
        }

        for (Integer integer : list) {
            num[depth] = integer;
            dfs(depth + 1, num);
        }
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