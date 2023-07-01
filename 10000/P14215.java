import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P14215 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sides = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(sides);
        if (sides[2] >= sides[0] + sides[1]) {
            sides[2] = sides[0] + sides[1] - 1;
        }
        System.out.println(sides[0] + sides[1] + sides[2]);
    }
}
