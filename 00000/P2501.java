import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int count = 1;
        boolean print = false;
        for (int i = 1; i <= N; i++){
            if (N % i == 0){
                if (count == K) {
                    System.out.println(i);
                    print = true;
                    break;
                }
                count++;
            }
        }
        if (!print) System.out.println("0");
    }
}
