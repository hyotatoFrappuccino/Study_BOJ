import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P4344 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int avg = (IntStream.of(nums).sum() - nums[0]) / nums[0];
            double count = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] > avg) count++;
            }
            String result = String.format("%.3f", count/nums[0]*100);
            System.out.println(result + "%");
        }
    }
}
