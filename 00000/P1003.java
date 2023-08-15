import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class P1003 {
    static  Map<Integer, Map.Entry<Integer, Integer>> fibo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fibo = new HashMap<>();
        fibo.put(0, new AbstractMap.SimpleEntry<>(1, 0));
        fibo.put(1, new AbstractMap.SimpleEntry<>(0, 1));
//        System.out.println(fibo.get(0).getKey());
//        System.out.println(fibo.get(0).getValue());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            getFibo(num);
            sb.append(fibo.get(num).getKey()).append(" ").append(fibo.get(num).getValue()).append("\n");
        }
        System.out.println(sb);
    }

    public static Map.Entry<Integer, Integer> getFibo(int n) {
        if (n < 2) {
            return fibo.get(n);
        }
        int result0 = 0;
        int result1 = 0;
        if (fibo.containsKey(n-1)) {
            result0 += fibo.get(n-1).getKey();
            result1 += fibo.get(n-1).getValue();
        }
        else {
            result0 += getFibo(n-1).getKey();
            result1 += getFibo(n-1).getValue();
        }

        if (fibo.containsKey(n-2)) {
            result0 += fibo.get(n-2).getKey();
            result1 += fibo.get(n-2).getValue();
        }
        else {
            result0 += getFibo(n-2).getKey();
            result1 += getFibo(n-2).getValue();
        }
        fibo.put(n, new AbstractMap.SimpleEntry<>(result0, result1));
        return new AbstractMap.SimpleEntry<>(result0, result1);
    }
}
