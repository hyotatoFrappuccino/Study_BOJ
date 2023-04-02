import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2562 {
    static int SIZE = 9;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[SIZE];
        for (int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index + 1);
    }
}
