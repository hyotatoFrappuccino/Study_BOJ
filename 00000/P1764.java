import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set1.add(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            set2.add(br.readLine());
        }
        set1.retainAll(set2);
        List<String> list = new ArrayList<>(set1);
        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str).append("\n");
        }
        System.out.println(set1.size());
        System.out.println(sb);
    }
}
