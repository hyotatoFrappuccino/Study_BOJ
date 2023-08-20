import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1264 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            char[] input = br.readLine().toCharArray();
            if (input.length == 1 && input[0] == '#') break;
            int count = 0;
            for (char c : input) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                 || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                    count++;
            }
            System.out.println(count);
        }
    }
}
