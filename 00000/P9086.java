import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9086 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            System.out.println(input.charAt(0) + "" + input.charAt(input.length()-1));
        }
    }
}
