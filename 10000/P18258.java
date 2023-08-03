import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18258 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String last = "";
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    String num = st.nextToken();
                    queue.add(num);
                    last = num;
                    break;
                case "pop":
                    if (!queue.isEmpty())
                        sb.append(queue.poll()).append("\n");
                    else
                        sb.append(-1 + "\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty())
                        sb.append(1 + "\n");
                    else
                        sb.append(0 + "\n");
                    break;
                case "front":
                    if (!queue.isEmpty())
                        sb.append(queue.peek()).append("\n");
                    else
                        sb.append(-1 + "\n");
                    break;
                case "back":
                    if (!queue.isEmpty())
                        sb.append(last).append("\n");
                    else
                        sb.append(-1 + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
