import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        long[] list = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] sum = new long[N+1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + list[i-1];
        }
        for (int k = 0; k < M; k++) {
            String[] ij = br.readLine().split(" ");
            int i = Integer.parseInt(ij[0]);
            int j = Integer.parseInt(ij[1]);
            System.out.println(sum[j] - sum[i-1]);
        }
    }
}
