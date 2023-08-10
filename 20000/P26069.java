import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P26069 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> list = new HashSet<>();
        list.add("ChongChong");
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String p1 = st.nextToken();
            String p2 = st.nextToken();
            if (list.contains(p1) || list.contains(p2)) {
                list.add(p1);
                list.add(p2);
            }
        }
        System.out.println(list.size());
    }
}
