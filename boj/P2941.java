import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] alp = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int sum = 0;
        for (String str : alp) {
            sum += (input.length() - input.replace(str, "").length()) / str.length();
            input = input.replace(str, "!");
        }
        input = input.replace("!", "");
        System.out.println(sum + input.length());
    }
}
