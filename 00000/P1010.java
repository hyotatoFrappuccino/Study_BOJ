import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010 {
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[M+1][N+1];
            System.out.println(comb(M, N));
        }
    }

    public static int comb(int n, int r) {
        if (n == r || r == 0) return 1;
        if (arr[n][r] != 0) return arr[n][r];
        else return arr[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}
