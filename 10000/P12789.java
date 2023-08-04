import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P12789 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int next = 1;
        Stack<Integer> stack = new Stack<>();
        boolean result = true;
        while (!list.isEmpty()) {
            int num = list.remove(0);
            if (num == next) next++;
            else stack.push(num);
            while (!stack.isEmpty()) {
                if (stack.peek() == next) {
                    stack.pop();
                    next++;
                }
                else break;
            }
            if (list.isEmpty() && !stack.isEmpty() && stack.peek() != next) {
                result = false;
            }
        }
        if (result) System.out.println("Nice");
        else System.out.println("Sad");
    }
}
