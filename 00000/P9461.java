import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] list = new long[N+4];
            list[0] = list[1] = list[2] = 1;
            list[3] = list[4] = 2;
            for (int j = 5; j < N; j++) {
                list[j] = list[j - 1] + list[j - 5];
            }
            sb.append(list[N-1]).append("\n");
        }
        System.out.println(sb);
    }
}
