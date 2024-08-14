import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16139 {
    static String text;
    static int q;
    static char[] a;
    static Set<Character> aSet;
    static int[] l;
    static int[] r;
    static StringBuilder output;

    static void input(String[] lines) {
        text = lines[0];
        q = Integer.parseInt(lines[1]);
        a = new char[q];
        aSet = new HashSet<>();
        l = new int[q];
        r = new int[q];

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(lines[i + 2]);
            char c = st.nextToken().charAt(0);
            a[i] = c;
            aSet.add(c);
            l[i] = Integer.parseInt(st.nextToken());
            r[i] = Integer.parseInt(st.nextToken());
        }

        output = new StringBuilder();
    }

    static String process() {
        // 알파벳별 누적합 구하기
        Map<Character, List<Integer>> sum = new HashMap<>();

        int len = text.length();
        for (Character comp : aSet) {
            List<Integer> prefixSum = new ArrayList<>();
            prefixSum.add(0);
            prefixSum.add(text.charAt(0) == comp ? 1 : 0);
            for (int i = 1; i < len; i++) {
                prefixSum.add(text.charAt(i) == comp ? prefixSum.get(i) + 1 : prefixSum.get(i));
            }
            sum.put(comp, prefixSum);
        }

        for (int i = 0; i < q; i++) {
            List<Integer> integers = sum.get(a[i]);
            output.append(integers.get(r[i] + 1) - integers.get(l[i])).append("\n");
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