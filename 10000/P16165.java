import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P16165 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, List<String>> list = new HashMap<>();
        Map<String, String> rev = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            List<String> temp = new ArrayList<>();
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < num; j++) {
                String name = br.readLine();
                temp.add(name);
                rev.put(name, groupName);
            }
            Collections.sort(temp);
            list.put(groupName, temp);
        }
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            String type = br.readLine();
            if (Objects.equals(type, "0")) {
                for (String s : list.get(input)) {
                    System.out.println(s);
                }
            } else {
                System.out.println(rev.get(input));
            }
        }
    }
}
