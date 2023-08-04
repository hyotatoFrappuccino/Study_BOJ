import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class P1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (true) {
            input =  br.readLine();
            if (Objects.equals(input, "0")) break;
            boolean palindrome = true;
            for (int i = 0; i < input.length() / 2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                    palindrome = false;
                    break;
                }
            }
            if (palindrome) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
