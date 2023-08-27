import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P6810 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "9780921418" + br.readLine() + br.readLine() + br.readLine();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            int sum1 = Integer.parseInt(String.valueOf(input.charAt(i)));
            if ((i & 1) == 0)
                sum += sum1;
            else
                sum += sum1 * 3;
        }
        System.out.println("The 1-3-sum is " + sum);
    }
}
