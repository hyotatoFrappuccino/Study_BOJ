import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P18110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int except = (int) Math.round(N * 0.15);
        int sum = 0;
        for (int i = except; i < N - except; i++) {
            sum += list[i];
        }
        System.out.println(Math.round((float) sum / (N - except * 2)));
    }
}
