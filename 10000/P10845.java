import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String last = "";
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    String num = st.nextToken();
                    queue.add(num);
                    last = num;
                    break;
                case "pop":
                    if (!queue.isEmpty())
                        sb.append(queue.poll()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty())
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                    break;
                case "front":
                    if (!queue.isEmpty())
                        sb.append(queue.peek()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case "back":
                    if (!queue.isEmpty())
                        sb.append(last).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
