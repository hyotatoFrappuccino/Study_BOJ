import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            boolean vps = true;
            int front = 0;
            int end = 0;
            char[] input = br.readLine().toCharArray();
            for (char c : input) {
                if (c == '(')
                    front++;
                else {
                    end++;
                    if (end > front) {
                        vps = false;
                        break;
                    }
                }
            }
            if (vps && front == end) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
