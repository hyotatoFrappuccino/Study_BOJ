import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("+");
        stack.push(1);
        int num = 2;
        boolean no = false;
        for (int k : input) {
            if (stack.size() > 0 && stack.peek() == k) {
                stack.pop();
                sb.append("-");
            } else {
                if (stack.size() > 0 && stack.peek() > k) {
                    no = true;
                    break;
                }
                for (int j = num; j <= k; j++) {
                    stack.push(num++);
                    sb.append("+");
                }
                stack.pop();
                sb.append("-");
            }
        }
        if (no) System.out.println("NO");
        else {
            for (int i = 0; i < sb.length(); i++) {
                System.out.println(sb.charAt(i));
            }
        }
    }
}
