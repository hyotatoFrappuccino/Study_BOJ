import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class P1546 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        시험 본 과목의 개수
        int N = Integer.parseInt(br.readLine());
        double[] nums = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double max = nums[0];
        for (int i = 1; i < N; i++) if (nums[i] > max) max = nums[i];
        for (int i = 0; i < N; i++) {
            nums[i] = nums[i] / max * 100;
        }
        System.out.println(DoubleStream.of(nums).sum() / N);
    }
}
