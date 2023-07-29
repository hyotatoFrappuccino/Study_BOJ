import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K - 1; j++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            if (!queue.isEmpty())
                sb.append(", ");
            else
                sb.append(">");
        }
        System.out.println(sb);
    }
}
