import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P18004 {
    static int A;
    static int B;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    static String process() {
        return String.valueOf(bfs());
    }

    private static int bfs() {
        Deque<Node> q = new LinkedList<>();
        q.add(new Node(A, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            int num = cur.getNum();
            int count = cur.getCount();

            if (num == B) {
                return count;
            }

            if (num > B) {
                if ((num & 1) == 0) {
                    q.add(new Node(num / 2, count + 1));
                } else {
                    q.add(new Node(num + 1, count + 1));
                }
            } else {
                return count + (B - num);
            }


        }
        return -1;
    }

    static class Node {
        private final int num;
        private final int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.println(process());
    }

    private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);
        return linesArray;
    }
}