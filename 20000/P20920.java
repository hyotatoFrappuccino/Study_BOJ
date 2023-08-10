import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P20920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() >= M) {
                if (!map.containsKey(input))
                    map.put(input, 1);
                else
                    map.put(input, map.get(input) + 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if (!Objects.equals(o1.getValue(), o2.getValue())) return o2.getValue() - o1.getValue();
            else if (!Objects.equals(o1.getKey().length(), o2.getKey().length())) return o2.getKey().length() - o1.getKey().length();
            else return o1.getKey().compareTo(o2.getKey());
        });
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : list){
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}
