import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1085 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = input[0];
        int y = input[1];
        int w = input[2];
        int h = input[3];
        System.out.println(Math.min(x, Math.min(y, Math.min(w-x, h-y))));
    }
}
