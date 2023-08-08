import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2447 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] result = star(N);
        StringBuilder sb = new StringBuilder();
        for (char[] chars : result) {
            sb.append(chars).append("\n");
        }
        System.out.println(sb);
    }

    public static char[][] star(int n) {
        char[][] outSide;
        char[][] result = new char[n][n];
        if (n > 3) {
            outSide = star(n / 3);
            for (int i = 0; i < outSide.length; i++) {
                for (int j = 0; j < outSide.length; j++) {
                    result[i][j] = outSide[i][j];
                    result[n / 3 + i][j] = outSide[i][j];
                    result[n / 3 * 2 + i][j] = outSide[i][j];
                    result[i][n / 3 + j] = outSide[i][j];
                    result[n / 3 * 2 + i][n / 3 + j] = outSide[i][j];
                    result[i][n / 3 * 2 + j] = outSide[i][j];
                    result[n / 3 + i][n / 3 * 2 + j] = outSide[i][j];
                    result[n / 3 * 2 + i][n / 3 * 2 + j] = outSide[i][j];
                    result[n / 3 + i][n / 3 + j] = ' ';
                }
            }
            return result;
        }
        else {
            return new char[][]{{'*', '*', '*'},
                                {'*', ' ', '*'},
                                {'*', '*', '*'}};
        }
    }
}
