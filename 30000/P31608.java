import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P31608 {
    static int N;
    static String S;
    static String T;
    static StringBuilder output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        S = lines[1];
        T = lines[2];
        output = new StringBuilder();
    }

    static String process() {
        int res = 0;

        char[] sArr = S.toCharArray();
        char[] tArr = T.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                res += 1;
            }
        }

        return String.valueOf(res);
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