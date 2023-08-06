import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1037 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        int min = Integer.MAX_VALUE;
        int[] input = new int[50];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            if (input[i] > max) max = input[i];
            if (input[i] < min) min = input[i];
        }
        if ((max & 1) == 0)
            System.out.println(max << 1);
        else {
            System.out.println(min * max);
        }
    }
}
