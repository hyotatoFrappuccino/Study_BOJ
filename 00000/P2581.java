import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2581 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = N;

//        입력 받은 숫자들에 대해서 소수인지 판별
        for (int num = M; num <= N; num++) {
            if (num == 1) continue;
            boolean prime = true;

            // 2 ~ Math.sqrt(num) 사이의 수와 나누어 떨어진다면 소수가 아님
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                sum += num;
                if (num < min) min = num;
            }
        }
        if (sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        } else
            System.out.println(-1);
    }
}
