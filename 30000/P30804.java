import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P30804 {
    static int N;
    static int[] list;
    static Map<Integer, Integer> map;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = new int[N];
        map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(lines[1]);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list[i] = num;
        }
    }

    static String process() {
        int start = 0;
        int res = 0;

        for (int end = 0; end < N; end++) {
            map.put(list[end], map.getOrDefault(list[end], 0) + 1);

            while (map.size() >= 3) {
                map.put(list[start], map.get(list[start]) - 1);

                if (map.get(list[start]) == 0) {
                    map.remove(list[start]);
                }
                start++;
            }

            res = Math.max(res, end - start + 1);
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.print(process());
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