import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                System.out.println("0");
                continue;
            }
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                String type = input[1];
                // 옷을 안 입는 경우까지 2가지다!
                if (!hashMap.containsKey(type)) hashMap.put(type, 2);
                else hashMap.put(type, hashMap.get(type) + 1);
            }
            int mul = 1;
            for (int n : hashMap.values()) {
                mul *= n;
            }
            // 모두 안 입는 경우인 1을 빼준다
            System.out.println(mul - 1);
        }
    }
}
