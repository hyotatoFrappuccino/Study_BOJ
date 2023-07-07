import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = nm[0];
        int M = nm[1];
        long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] sum = new long[N];
        sum[0] = input[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + input[i];
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            sum[i] %= M;
            if (sum[i] == 0) result++;
        }
        for (int i = 0; i < M; i++) {
            long count = 0;
            for (int j = 0; j < N; j++) {
                if (sum[j] == i) count++;
            }
            if (count > 1)
                result += count * (count - 1) / 2;
        }
        System.out.println(result);
    }
}
