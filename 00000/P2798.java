import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0;
        for (int i = 0; i < input.length - 2; i++) {
            for (int j = i + 1; j < input.length - 1; j++) {
                for (int k = j + 1; k < input.length; k++) {
                    int sum = input[i] + input[j] + input[k];
                    if (sum > max && sum <= M) max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
