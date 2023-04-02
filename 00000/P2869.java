import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2869 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A, B, V;
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        A = input[0];
        B = input[1];
        V = input[2];
        int day = (V - B) / (A - B);
        if ((V - B) % (A - B) != 0) day++;
        System.out.println(day);
    }
}
