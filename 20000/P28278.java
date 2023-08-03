import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P28278 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "1":
                    stack.push(st.nextToken());
                    break;
                case "2":
                    if (!stack.isEmpty())
                        sb.append(stack.pop()).append("\n");
                    else
                        sb.append(-1 + "\n");
                    break;
                case "3":
                    sb.append(stack.size()).append("\n");
                    break;
                case "4":
                    if (stack.isEmpty())
                        sb.append(1 + "\n");
                    else
                        sb.append(0 + "\n");
                    break;
                case "5":
                    if (!stack.isEmpty())
                        sb.append(stack.peek()).append("\n");
                    else
                        sb.append(-1 + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
