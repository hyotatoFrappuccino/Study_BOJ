import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P11003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayDeque<Node> deque = new ArrayDeque<>();
        int[] result = new int[N];
        // list 배열 순회
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            // deque 크기 비교
            while (!deque.isEmpty() && deque.getLast().value > value) {
                deque.removeLast();
            }
            deque.offer(new Node(i, value));
            if (deque.getFirst().index <= i - L) deque.removeFirst();
            result[i] = deque.getFirst().value;
//            bw.write(deque.getFirst().value + " ");
        }
        for (int i = 0; i < N; ++i) {
            bw.write(result[i] + " ");
        }
        bw.flush();
    }

    static class Node {
        public int index;
        public int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}

