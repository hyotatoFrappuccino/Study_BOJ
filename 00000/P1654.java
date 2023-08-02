import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] list = new int[K];
        for (int i = 0; i < K; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        long start = 0;
        long end = list[list.length - 1];
        end++;
        long mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            long nSum = 0;
            for (int i : list) {
                nSum += i / mid;
            }
            if (nSum < N) end = mid;
            else start = mid + 1;
        }
        System.out.println(start - 1);

    }
}
