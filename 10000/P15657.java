import java.io.*;
import java.util.*;

public class P15657 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i : array) {
            list.add(i);
        }
        list.sort(Comparator.naturalOrder());

        NM9(new int[M], list, 0, M);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void NM9(int[] result, List<Integer> list, int depth, int maxDepth) throws IOException {
        if (depth == maxDepth) {
            StringBuilder sb = new StringBuilder();
            for (int i : result) {
                sb.append(i).append(" ");
            }
            bw.append(sb).append("\n");
            return;
        }
        for (Integer num : list) {
            if (depth > 0 && result[depth-1] > num) continue;
            result[depth] = num;
            NM9(result, list, depth + 1, maxDepth);
        }

    }
}