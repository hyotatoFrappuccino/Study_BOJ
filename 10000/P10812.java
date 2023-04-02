import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10812 {
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
            String in = br.readLine();
            input = in.split(" ");
            int begin = Integer.parseInt(input[0]) - 1;
            int end = Integer.parseInt(input[1]) - 1;
            int mid = Integer.parseInt(input[2]) - 1;
            int[] temp1 = Arrays.copyOfRange(list, begin, mid);
            int[] temp2 = Arrays.copyOfRange(list, mid, end+1);
            int[] dest = new int[temp1.length + temp2.length];
            System.arraycopy(temp2, 0, dest, 0, temp2.length);
            System.arraycopy(temp1, 0, dest, temp2.length, temp1.length);
            System.arraycopy(dest, 0, list, begin, dest.length);
        }
        for (int n : list) {
            System.out.printf(n + " ");
        }
    }
}
