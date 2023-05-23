import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1978 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
//        입력 받은 숫자들에 대해서 소수인지 판별
        for (int i = 0; i < N; i++) {
            int num = list[i];
            boolean prime = true;
            if (num == 1) {
                prime = false;
            } else {
                //            2 ~ (num - 1) 사이의 수와 나누어 떨어진다면 소수가 아님
                for (int j = 2; j < num; j++) {
                    if (num % j == 0) {
                        prime = false;
                        break;
                    }
                }
            }
            if (prime) count++;
        }
        System.out.println(count);
    }
}
