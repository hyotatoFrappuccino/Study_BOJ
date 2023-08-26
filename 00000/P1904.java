import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1904 {
    static int[] list = new int[10000001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list[0] = list[1] = 1;
        for (int i = 2; i <= N; i++) {
            list[i] = (list[i - 2] + list[i - 1]) % 15746;
        }
        System.out.println(list[N]);
    }
}