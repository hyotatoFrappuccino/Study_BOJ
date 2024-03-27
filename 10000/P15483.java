import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P15483 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int aLen = a.length();
        int bLen = b.length();
        int[][] cost = new int[aLen + 1][bLen + 1];
        for (int i = 0; i <= aLen; i++) {
            cost[i][0] = i;
        }
        for (int i = 0; i <= bLen; i++) {
            cost[0][i] = i;
        }
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                cost[i][j] = Math.min(cost[i - 1][j] + 1, Math.min(cost[i - 1][j - 1] + (a.charAt(i - 1) != b.charAt(j - 1) ? 1 : 0), cost[i][j - 1] + 1));
            }
        }
        System.out.println(cost[aLen][bLen]);
    }
}
