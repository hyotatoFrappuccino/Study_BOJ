import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P3052 {
    static int SIZE = 10;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[SIZE];
        for (int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
//        중복을 허용하지 않는 HashSet
        HashSet<Integer> restNumbers = new HashSet<Integer>();
        for (int num : nums){
            restNumbers.add(num % 42);
        }
        System.out.println(restNumbers.size());
    }
}
