import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P6588 {

    private static final int primeLength = 1_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] prime = new boolean[primeLength + 1];
        Arrays.fill(prime, true);
        // 제곱근까지만 봐도 충분함
        for (int i = 2; i <= Math.sqrt(primeLength); i++) {
            if (!prime[i]) continue;
            for (int j = i * 2; j <= primeLength; j += i) {
                prime[j] = false;
            }
        }

        String input;
        while (!(input = br.readLine()).equals("0")) {
            int N = Integer.parseInt(input);
            boolean flag = false;
            // 소수가 3부터 시작하므로 3부터, 절반까지만 돌아도 되고, 홀수소수만보니 2씩만 증가한다
            for (int i = 3; i <= primeLength / 2; i += 2) {
                int B = N - i;
                if (prime[i] && prime[B]) {
                    bw.write(N + " = " + i + " + " + B + "\n");
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println("Goldbach's conjecture is wrong.");
        }
        bw.flush();
    }
}

