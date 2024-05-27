import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P19949 {
    static int[] answer;
    static int result;

    static void input(String[] lines) {
        answer = Arrays.stream(lines[0].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static String process() {
        dfs(0, new int[answer.length]);
        return String.valueOf(result);
    }

    private static void dfs(int idx, int[] list) {
        if (idx == answer.length) {
            int sum = 0;
            for (int i = 0; i < answer.length; i++) {
                if (list[i] == answer[i]) {
                    sum += 1;
                }
            }

            if (sum >= 5) {
                result++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (idx >= 2 && list[idx - 1] == i && list[idx - 2] == i) {
                continue;
            }

            list[idx] = i;
            dfs(idx + 1, list);
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