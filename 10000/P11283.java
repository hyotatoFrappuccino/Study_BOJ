import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11283 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char input = Character.toChars(br.readLine().charAt(0))[0];

        System.out.println(input - 0xAC00 + 1);
    }
}
