import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P2346 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            deque.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        Balloon balloon = deque.pollFirst();
        assert balloon != null;
        int move = balloon.getMove();
        sb.append(balloon.getIndex()).append(" ");
        while (!deque.isEmpty()) {
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else if (move < 0) {
                for (int i = move; i < 0; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
            balloon = deque.pollFirst();
            assert balloon != null;
            move = balloon.getMove();
            sb.append(balloon.getIndex()).append(" ");
        }
        System.out.println(sb);
    }
}

class Balloon {
    @Override
    public String toString() {
        return "{" + index + "," + move + "}";
    }

    int index;
    int move;

    public Balloon(int index, int move) {
        this.index = index;
        this.move = move;
    }

    public int getIndex() {
        return index;
    }

    public int getMove() {
        return move;
    }
}