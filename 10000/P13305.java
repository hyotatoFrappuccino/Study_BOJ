import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P13305 {
    static int N;
    static int[] len;
    static int[] price;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        StringTokenizer st = new StringTokenizer(lines[1]);
        len = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            len[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(lines[2]);
        price = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
    }

    static String process() {
        long cost = 0;
        long last = price[0];

        for (int i = 0; i < N - 1; i++) {
            cost += last * len[i];
            if (price[i + 1] < last) {
                last = price[i + 1];
            }
        }

        return String.valueOf(cost);
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