import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(str[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];
        stack.push(0);
        // 수열의 길이만큼 반복
        for (int i = 1; i < N; i++) {
            // Stack 원소 반복
            while (!stack.isEmpty() && list[stack.peek()] < list[i]) {
                answer[stack.pop()] = list[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
