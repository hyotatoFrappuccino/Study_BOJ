import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P24313 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a1 = a[0];
        int a0 = a[1];
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        if (a1*n0 + a0 <= c*n0 && a1 <= c) System.out.println(1);
        else System.out.println(0);
    }
}
