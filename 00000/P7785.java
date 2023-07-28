import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P7785 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        StringTokenizer st;
        String name;
        String type;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            name = st.nextToken();
            type = st.nextToken();
            if (Objects.equals(type, "enter")) map.put(name, name);
            else map.remove(name);
        }
        List<String> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String str : list) sb.append(str).append("\n");
        System.out.println(sb);
    }
}
