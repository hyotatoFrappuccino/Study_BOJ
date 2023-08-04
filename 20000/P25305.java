import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P25305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int K = input[1];
        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(list);
        System.out.println(list[N-K]);
    }
}
