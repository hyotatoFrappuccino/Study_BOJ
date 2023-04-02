import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2292 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int sum = 1;
        int sum6 = 6;
        if (n == 1)
            System.out.println(1);
        else{
            while (sum < n){
                sum += sum6;
                count += 1;
                sum6 += 6;
            }
            System.out.println(count);
        }
    }
}
