import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1436 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 665;
        int count = 0;
        while (true){
            result++;
            if (Integer.toString(result).contains("666")) count++;
            if (count == N) break;
        }
        System.out.println(result);
    }
}
