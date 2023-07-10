import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(list);
        int count = 0;
        int start = 0;
        int end = list.length - 1;
        while (start < end) {
            int sum = list[start] + list[end];
            if (sum == M) {
                count++;
                start++;
                end--;
            } else if (sum > M) {
                end--;
            } else start++;
        }
        System.out.println(count);
    }
}
