import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2711 {
    static int N;
    static int[] index;
    static List<String> list;
    static StringBuilder output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = new ArrayList<>();
        index = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(lines[i + 1]);
            index[i] = Integer.parseInt(st.nextToken());
            list.add(st.nextToken());
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < N; i++) {
            output.append(list.get(i).substring(0, index[i] - 1) + list.get(i).substring(index[i], list.get(i).length())).append("\n");

        }

        return output.toString();
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