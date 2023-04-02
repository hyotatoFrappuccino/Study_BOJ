import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14928 {
    private final static int MOD = 20000303;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int r = 0;
        for (int i = 0; i < n.length(); i++) {
            r = (r * 10 + (n.charAt(i) - '0')) % MOD;
        }
        System.out.println(r);
    }
}
