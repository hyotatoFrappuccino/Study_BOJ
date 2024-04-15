import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1748 {
    static int sum = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int N = Integer.parseInt(br.readLine());

        // process
        concatNum(N, 1, 1);
        bw.append(String.valueOf(sum));

        // output
        bw.flush();

        br.close();
        bw.close();
    }

    public static void concatNum(int N, int num, int length) {
        sum += Math.min((num * 10) - num, N - num + 1) * length;
        if (N <= num * 10 - 1) return;
        if (N * 10 == 100_000_000) return;
        concatNum(N, num * 10, length + 1);
    }
}
