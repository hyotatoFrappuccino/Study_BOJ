import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1717 {
    static StringBuilder output;
    static int N;
    static int M;
    static String[] input;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new String[M + 1];
        System.arraycopy(lines, 1, input, 1, M);
        output = new StringBuilder();
    }

    static String process() {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            list.add(set);
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(input[i]);
            System.out.println(input[i]);
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (type == 0) {
                Set<Integer> set = new HashSet<>();
                for (Set<Integer> integers : list) {
                    if (integers.contains(a))
                        set.addAll(integers);
                    if (integers.contains(b))
                        set.addAll(integers);
                }
//                System.out.println("set : " + set);
                list.set(a, set);
                list.set(b, set);
//                System.out.println("a list : " + list.get(a));
//                System.out.println("b list : " + list.get(b));
            } else {
//                System.out.println(list.get(a));
//                System.out.println(list.get(b));
                if (list.get(a).containsAll(list.get(b))) {
                    output.append("YES").append("\n");
                } else {
                    output.append("NO").append("\n");
                }
            }

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