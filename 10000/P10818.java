import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10818 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = nums[0];
        int max = nums[0];
        for (int num : nums){
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }
        System.out.println(min + " " + max);
    }
}
