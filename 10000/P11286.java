import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int absA = Math.abs(o1);
            int absB = Math.abs(o2);
            if (absA == absB)
                return o1 > o2 ? 1 : -1;
            else
                return absA - absB;
        });
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (queue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(queue.poll());
            } else
                queue.add(input);
        }
    }
}
