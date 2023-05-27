import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3009 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dot1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dot2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dot3 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int x, y;

        if (dot1[0] == dot2[0])
            x = dot3[0];
        else if (dot1[0] == dot3[0])
            x = dot2[0];
        else x = dot1[0];

        if (dot1[1] == dot2[1])
            y = dot3[1];
        else if (dot1[1] == dot3[1])
            y = dot2[1];
        else y = dot1[1];

        System.out.println(x + " " + y);
    }
}
