import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P16430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] AB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = AB[0];
        int B = AB[1];
        System.out.println(B-A + " " + B);
    }
}
