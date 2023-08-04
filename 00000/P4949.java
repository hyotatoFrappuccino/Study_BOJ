import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            char[] input = br.readLine().toCharArray();
            if (input[0] == '.' && input.length == 1) break;
            boolean result = true;
            Stack<Character> stack = new Stack<>();
            for (char c : input) {
                if (c == '(' || c == '[')
                    stack.push(c);
                else if (c == ')'){
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = false;
                        break;
                    }
                    else stack.pop();
                }
                else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '['){
                        result = false;
                        break;
                    }
                    else stack.pop();
                }
            }
            if (!stack.isEmpty()) result = false;
            if (result) sb.append("yes" + "\n");
            else sb.append("no" + "\n");
        }
        System.out.println(sb);
    }
}
