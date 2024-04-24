import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1248 {
    static StringBuilder output;
    static int N;
    static char[] sign;
    static char[][] matrix;
    static boolean end;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        matrix = new char[N][N];
        sign = lines[1].toCharArray();
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                matrix[i][j] = sign[idx++];
            }
        }
        output = new StringBuilder();
        end = false;
    }

    static String process() {
        dfs(new int[N], 0);

        return output.toString();
    }

    private static void dfs(int[] num, int depth) {
        if (end) return;
        if (depth == N) {
            if (isValid(num, depth)) {
                for (int i : num) {
                    output.append(i).append(" ");
                }
                end = true;
            }
            return;
        }

        for (int i = -10; i <= 10; i++) {
            num[depth] = i;
            if (isValid(num, depth + 1))
                dfs(num, depth + 1);
        }
    }

    private static boolean isValid(int[] num, int depth) {
        for (int i = 0; i < depth; i++) {
            int sum = 0;
            for (int j = i; j < depth; j++) {
                sum += num[j];
                if (matrix[i][j] == '+' && sum <= 0) return false;
                else if (matrix[i][j] == '-' && sum >= 0) return false;
                else if (matrix[i][j] == '0' && sum != 0) return false;
            }
        }
        return true;
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