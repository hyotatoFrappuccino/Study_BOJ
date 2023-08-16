import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9663 {
    static int[] queen;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queen = new int[N];
        nqueen(0);
        System.out.println(count);
    }

    public static void nqueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queen[depth] = i;
            if (possibility(depth)) {
                nqueen(depth + 1);
            }
        }
    }

    public static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (queen[i] == queen[col] || Math.abs(queen[i] - queen[col]) == Math.abs(i - col))
                return false;
        }
        return true;
    }
}
