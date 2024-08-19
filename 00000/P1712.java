import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1712 {
    static int A;
    static int B;
    static int C;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }

    static String process() {
//        A = 고정 비용
//        B = 1대당 생산비
//        C = 노트북 가격

        if (B >= C) {
            return String.valueOf(-1);
        } else {
            int num = A / (C - B);

            for (int i = num; i < Integer.MAX_VALUE; i++) {
                if (i * (C - B) - A > 0) {
                    return String.valueOf(i);
                }
            }
        }

        return "-1";
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