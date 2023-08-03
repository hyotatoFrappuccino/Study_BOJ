import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P28279 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "1":
                    deque.addFirst(st.nextToken());
                    break;
                case "2":
                    deque.addLast(st.nextToken());
                    break;
                case "3":
                    if (!deque.isEmpty())
                        sb.append(deque.pollFirst()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case "4":
                    if (!deque.isEmpty())
                        sb.append(deque.pollLast()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case "5":
                    sb.append(deque.size()).append("\n");
                    break;
                case "6":
                    if (deque.isEmpty())
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                    break;
                case "7":
                    if (!deque.isEmpty())
                        sb.append(deque.peekFirst()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case "8":
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
