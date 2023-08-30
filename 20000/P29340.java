import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P29340 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input1.length(); i++) {
            if (input2.charAt(i) > input1.charAt(i))
                sb.append(input2.charAt(i));
            else
                sb.append(input1.charAt(i));
        }
        System.out.println(sb);
    }
}
