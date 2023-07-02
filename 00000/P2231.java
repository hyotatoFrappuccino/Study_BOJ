import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2231 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        boolean exits = false;
        for (int length = input.length() - 1; length <= input.length(); length++) {
            if (exits) break;
            for (int i = (int) Math.pow(10, length - 1); i < (int) Math.pow(10, length) - 1; i++) {
                int result = i;
                String istr = Integer.toString(result);
                for (int j = 0; j < istr.length(); j++) {
                    result += Integer.parseInt(String.valueOf(istr.charAt(j)));
                }
                if (result == N) {
                    exits = true;
                    System.out.println(i);
                    break;
                }
            }
        }
        if (!exits) System.out.println(0);
    }
}
