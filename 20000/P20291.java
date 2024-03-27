import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P20291 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> list = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("\\.");
            String key = input[1];
            if (list.containsKey(key)) {
                list.put(key, list.get(key) + 1);
            } else {
                list.put(key, 1);
            }
        }
        for (String s : list.keySet()) {
            System.out.println(s + " " + list.get(s));
        }
    }
}
