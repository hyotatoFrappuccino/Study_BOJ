import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2458 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int gcd = b - a;
        list.add(b - a);
        for (int i = 0; i < num - 2; i++) {
            int input = Integer.parseInt(br.readLine());
            gcd = gcd(gcd, input - b);
            list.add(input - b);
            b = input;
        }
        int sum = 0;
        for (int i : list) {
            sum += i/gcd-1;
        }
        System.out.println(sum);
    }

    public static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
}
