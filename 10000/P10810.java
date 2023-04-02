import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class P10810 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] list = new int[N];
        for (int l = 0; l < M; l++) {
            input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            for (int m = i-1; m <= j-1; m++) {
                list[m] = k;
            }
        }
        for (int n : list) {
            System.out.printf(n + " ");
        }

    }
}
