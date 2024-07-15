import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1459 {
    static int X;
    static int Y;
    static int W;
    static int S;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        output = new StringBuilder();
    }

    static String process() {
//        bfs();

        long time = 0;

        // 대각선으로 가는게 빠른경우
        if (W * 2 >= S) {
            int min = Math.min(X, Y);
            time += (long) min * S;

            int remain = Math.max(X, Y) - min;

            if (remain >= 2 && S * 2 < W * 2) {
                time += (long) remain / 2 * 2 * S;
                remain %= remain / 2 * 2;
                time += (long) remain * W;
            } else {
                time += (long) remain * W;
            }


        } else {
            // 1칸씩 가는게 빠른경우
            time += (long) X * W + (long) Y * W;
        }
        return String.valueOf(time);
    }

//    static void bfs() {
//        Queue<Node> q = new LinkedList<Node>();
//        q.add(new Node(0, 0, 0));
////        boolean[][] visited = new boolean[X + 1][Y + 1];
//
//        while(!q.isEmpty()) {
//            Node cur = q.poll();
//
//            int x = cur.getX();
//            int y = cur.getY();
//            int time = cur.getTime();
//            output.append("%d, %d : %d\n".formatted(x, y, time));
//
//            if (x == X && y == Y) {
//                output.append(time);
//                break;
//            }
//            q.add(new Node(x + 1, y, time + W));
//            q.add(new Node(x, y + 1, time + W));
//            q.add(new Node(x + 1, y + 1, time + S));
//
//
////            if (isValidPosition(x + 1, y) && !visited[x + 1][y]) {
////                q.add(new Node(x + 1, y, time + W));
////                visited[x + 1][y] = true;
////            }
////
////            if (isValidPosition(x, y + 1) && !visited[x][y + 1]) {
////                q.add(new Node(x, y + 1, time + W));
////                visited[x][y + 1] = true;
////            }
////
////            if (isValidPosition(x + 1, y + 1) && !visited[x + 1][y + 1]) {
////                q.add(new Node(x + 1, y + 1, time + S));
////                visited[x + 1][y + 1] = true;
////            }
//
//        }
//    }

//    static boolean isValidPosition(int x, int y) {
//        return x >= 0 && x <= X && y >= 0 && y <= Y;
//    }

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

    static class Node {
        private final int x;
        private final int y;
        private final int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getTime() {
            return time;
        }
    }
}