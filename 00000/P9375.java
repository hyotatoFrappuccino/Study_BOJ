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

            // Map을 이용해 조합 계산을 위한 의상 종류별 개수를 계산한다.
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                String type = input[1];
                // 옷을 안 입는 경우까지 2가지 경우를 계산해야 하므로, 개수를 2개로 해준다.

                // 해당 종류의 의상을 처음 map에 넣는 경우
                if (!hashMap.containsKey(type)) hashMap.put(type, 2);
                // 해당 종류의 의상이 이미 map에 있다면, 개수를 1개 더해준다.
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
