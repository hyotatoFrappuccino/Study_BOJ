import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P26902 {
    static String address;
    static int count;

    static void input(String[] lines) {
        address = lines[0];
        count = 0;
    }

    static String process() {
        dfs(new int[4], 0);
        return String.valueOf(count);
    }

    static void dfs(int[] list, int depth) {
        if (depth == 4) {
            int sum = 0;
            for (int i : list) {
                sum += i;
            }
            if (sum == address.length() && isValid(list)) {
                count++;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            list[depth] = i;
            dfs(list, depth + 1);
        }
    }

    private static boolean isValid(int[] list) {
        int idx = 0;
        for (int i : list) {
            String s = address.substring(idx, idx + i);
            if (s.length() == 2 && s.startsWith("0") ||
                s.length() == 3 && s.startsWith("00")) return false;
            int intS = Integer.parseInt(s);
            if (intS > 255) {
                return false;
            }
            idx += i;
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