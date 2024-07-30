import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P4807 {
    static List<List<Integer>> list;
    static StringBuilder output;

    static void input(String[] lines) {
        int idx = 0;
        list = new ArrayList<>();
        while (true) {
            int N = Integer.parseInt(lines[idx++]);
            if (N == 0) break;
            StringTokenizer st = new StringTokenizer(lines[idx++]);
            while (st.hasMoreTokens()) {
                List<Integer> inputs = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    inputs.add(Integer.parseInt(st.nextToken()));
                }
                list.add(inputs);
            }
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            if (isAllIsN(list.get(i))) {
                count = 0;
            } else {
                count = calc(list.get(i));

            }

            if (count != -1) {
                output.append("Case %d: %d iterations\n".formatted(i + 1, count));
            } else {
                output.append("Case %d: not attained\n".formatted(i + 1));
            }

        }

        return output.toString();
    }

    private static int calc(List<Integer> integers) {
        int iter = 1;

        while (true) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < integers.size() - 1; i++) {
                list.add(Math.abs(integers.get(i) - integers.get(i + 1)));
            }
            list.add(Math.abs(integers.get(integers.size() - 1) - integers.get(0)));

            boolean allIsN = isAllIsN(list);
            integers = list;

            if (allIsN) {
                break;
            }

            if (iter >= 1000) {
                return -1;
            }

            iter++;
        }

        return iter;
    }

    private static boolean isAllIsN(List<Integer> list) {
        boolean allIsN = true;
        for (int i : list) {
            if (i != list.get(0)) {
                allIsN = false;
                break;
            }
        }
        return allIsN;
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