import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10813 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = i+1;
        }
        for (int l = 0; l < M; l++) {
            input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            int temp = list[j-1];
            list[j-1] = list[i-1];
            list[i-1] = temp;
        }
        for (int n : list) {
            System.out.printf(n + " ");
        }

    }
}
