import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class P9184 {
    static int[][][] matrix = new int[21][21][21];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        while (true) {
            input = br.readLine();
            if (Objects.equals(input, "-1 -1 -1")) break;
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(recur(a, b, c)).append("\n");
        }
        System.out.println(sb);
    }

    public static int recur(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        if (a > 20 || b > 20 || c > 20)
            return recur(20, 20, 20);
        if (a < b && b < c) {
            int aa;
            int bb;
            int cc;
            if (matrix[a][b][c - 1] != 0)
                aa = matrix[a][b][c - 1];
            else {
                aa = recur(a, b, c - 1);
                matrix[a][b][c - 1] = aa;
            }
            if (matrix[a][b - 1][c - 1] != 0)
                bb = matrix[a][b - 1][c - 1];
            else {
                bb = recur(a, b - 1, c - 1);
                matrix[a][b - 1][c - 1] = bb;
            }
            if (matrix[a][b - 1][c] != 0)
                cc = matrix[a][b - 1][c];
            else {
                cc = recur(a, b - 1, c);
                matrix[a][b - 1][c] = cc;
            }
            return aa + bb - cc;
//            return recur(a, b, c - 1) + recur(a, b - 1, c - 1) - recur(a, b - 1, c);
        }
        int aa;
        int bb;
        int cc;
        int dd;
        if (matrix[a - 1][b][c] != 0)
            aa = matrix[a - 1][b][c];
        else {
            aa = recur(a - 1, b, c);
            matrix[a - 1][b][c] = aa;
        }
        if (matrix[a - 1][b - 1][c] != 0)
            bb = matrix[a - 1][b - 1][c];
        else {
            bb = recur(a - 1, b - 1, c);
            matrix[a - 1][b - 1][c] = bb;
        }
        if (matrix[a - 1][b][c - 1] != 0)
            cc = matrix[a - 1][b][c - 1];
        else {
            cc = recur(a - 1, b, c - 1);
            matrix[a - 1][b][c - 1] = cc;
        }
        if (matrix[a - 1][b - 1][c - 1] != 0)
            dd = matrix[a - 1][b - 1][c - 1];
        else {
            dd = recur(a - 1, b - 1, c - 1);
            matrix[a - 1][b - 1][c - 1] = dd;
        }
        return aa + bb + cc - dd;
//        return recur(a - 1, b, c) + recur(a - 1, b - 1, c) + recur(a - 1, b, c - 1) - recur(a - 1, b - 1, c - 1);
    }
}
