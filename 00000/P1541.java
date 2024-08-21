import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1541 {
    static int[] list;
    static char[] oper;
    static int len;

    static void input(String[] lines) {
        char[] expr = lines[0].toCharArray();
        list = new int[30];
        oper = new char[30];

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (char c : expr) {
            if (c == '+' || c == '-') {
                list[idx] = Integer.parseInt(sb.toString());
                oper[idx++] = c;
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        list[idx++] = Integer.parseInt(sb.toString());
        len = idx;
    }

    static String process() {
        int result = 0;
        char lastOper = '+';

        for (int i = 0; i < len; i++) {
            if (lastOper == '+') {
                result += list[i];
            } else {
                result -= list[i];
            }

            if (oper[i] == '-') {
                lastOper = '-';
            }
        }

        return String.valueOf(result);
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