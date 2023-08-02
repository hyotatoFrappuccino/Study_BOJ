import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P17103 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = new boolean[1000001];
        // 소수면 false, 아니면 true
        prime[0] = prime[1] = true;
        for (int i = 2; i <= 1000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    prime[j] = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 1000000; i++) {
            if (!prime[i]) list.add(i);
        }
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; i++) {
            int N = Integer.parseInt(br.readLine());
            Iterator<Integer> it = list.iterator();
            int count = 0;
            while (true) {
                int sub = it.next();
                if (sub > N / 2) break;
                if (!prime[N - sub]) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
