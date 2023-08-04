import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front":
                    deque.addFirst(st.nextToken());
                    break;
                case "push_back":
                    deque.addLast(st.nextToken());
                    break;
                case "pop_front":
                    if (!deque.isEmpty())
                        sb.append(deque.pollFirst()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case "pop_back":
                    if (!deque.isEmpty())
                        sb.append(deque.pollLast()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty())
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                    break;
                case "front":
                    if (!deque.isEmpty())
                        sb.append(deque.peekFirst()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case "back":
                    if (!deque.isEmpty())
                        sb.append(deque.peekLast()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
