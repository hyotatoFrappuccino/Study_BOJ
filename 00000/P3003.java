import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3003 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i <= 5; i++){
            System.out.print(check(i, nums[i]) + " ");
        }
    }

    private static int check(int i, int num){
        switch (i){
            case 0: case 1:
                return 1 - num;
            case 2: case 3: case 4:
                return 2 - num;
            case 5:
                return 8 - num;
            default:
                return 0;
        }
    }
}
