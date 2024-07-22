import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P6426 {
    static List<int[]> list;
    static StringBuilder output;

    static void input(String[] lines) {
        int idx = 0;
        list = new ArrayList<>();
        while (true) {
            String input = lines[idx++];
            if (!input.equals("0 0 0 0")) {
                int[] s = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                list.add(s);
            } else {
                break;
            }
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < list.size(); i++) {
            int[] nums = list.get(i);
            int Z = nums[0];
            int I = nums[1];
            int M = nums[2];
            int L = nums[3];

            Map<Integer, Integer> seen = new HashMap<>();
            int step = 0;

            while (!seen.containsKey(L)) {
                seen.put(L, step);
                L = (Z * L + I) % M;
                step++;
            }

            int cycleLength = step - seen.get(L);
            output.append(String.format("Case %d: %d%n", i + 1, cycleLength));
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