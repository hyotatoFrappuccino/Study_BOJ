import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10870 {
    static int[] list = new int[21];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list[0] = 0;
        list[1] = 1;
        int N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }

    public static int fibo(int n) {
        if (n < 2) return list[n];
        int a = 0;
        if (list[n-1] > 0) a = list[n-1];
        else a = fibo(n - 1);
        int b = 0;
        if (list[n-2] > 0) b = list[n-2];
        else b = fibo(n - 2);
        return a + b;
    }
}
