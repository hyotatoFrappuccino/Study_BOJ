import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10988 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        boolean res = true;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                res = false;
                break;
            }
        }
        if (res) System.out.println(1);
        else System.out.println(0);
    }
}
