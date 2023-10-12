import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P2606 {
    static Map<Integer, ArrayList<Integer>> map;
    static boolean[] visited;
    static int sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        map = new HashMap<>();
        sum = 0;
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.get(key).add(value);
            map.get(value).add(key);
        }
        search(1);
        System.out.println(sum);
    }

    public static void search(int key) {
        for (int value : map.get(key)) {
            if (!visited[value-1]) {
                if (value == 1)
                    continue;
                visited[value-1] = true;
                search(value);
                sum++;
            }
        }
    }
}
