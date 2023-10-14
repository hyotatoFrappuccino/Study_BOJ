import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11721 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len / 10; i++) {
            sb.append(input, i * 10, i * 10 + 10).append("\n");
        }
        sb.append(input, len / 10 * 10, len);
        System.out.println(sb);
    }
}
