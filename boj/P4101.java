import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P4101 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null && !input.isEmpty()){
            int[] NUM = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int num1 = NUM[0];
            int num2 = NUM[1];
            if (num1 == 0 && num2 == 0) break;
            if (num1 > num2) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
