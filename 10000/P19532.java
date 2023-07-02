import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P19532 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = input[0];
        int b = input[1];
        int c = input[2];
        int d = input[3];
        int e = input[4];
        int f = input[5];

        for (int x = -999; x < 1000; x++) {
            for (int y = -999; y < 1000; y++) {
                if (a*x + b*y - c == 0 && d*x + e*y - f == 0)
                    System.out.println(x + " " + y);
            }
        }
    }
}
