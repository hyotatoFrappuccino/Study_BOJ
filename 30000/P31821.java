import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P31821 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }
        int peoples = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < peoples; i++) {
            sum += prices[Integer.parseInt(br.readLine()) - 1];
        }

        bw.append(String.valueOf(sum));

        bw.flush();

        br.close();
        bw.close();
    }
}
