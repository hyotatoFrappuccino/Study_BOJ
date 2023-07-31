import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                stack.add(num);
            }
            else stack.pop();
        }
        int sum = 0;
        for (int i : stack)
            sum += i;
        System.out.println(sum);
    }
}
