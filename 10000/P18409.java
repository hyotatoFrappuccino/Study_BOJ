import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P18409 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String input = br.readLine();
        int sum = 0;
        for (char c : input.toCharArray()) {
            if (c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o') {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
