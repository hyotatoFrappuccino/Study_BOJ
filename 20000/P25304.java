import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P25304 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < count; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sum += input[0] * input[1];
        }
        if (total == sum)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
