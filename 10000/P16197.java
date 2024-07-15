import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static List<Integer> coinxy;
    static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        coinxy = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            char[] charArray = lines[i + 1].toCharArray();
            for (int j = 0; j < M; j++) {
                int state = -1;
                switch (charArray[j]) {
                    case '.':
                        state = STATE.EMPTY;
                        break;
                    case 'o':
                        state = STATE.EMPTY;
                        coinxy.add(i);
                        coinxy.add(j);
                        break;
                    case '#':
                        state = STATE.WALL;
                        break;
                }
                board[i][j] = state;
            }
        }
    }

    static String process() {
        int result = bfs(coinxy.get(0), coinxy.get(1), coinxy.get(2), coinxy.get(3));
        return String.valueOf(result);
    }

    static int bfs(int initX1, int initY1, int initX2, int initY2) {
        Queue<Coin> queue = new LinkedList<>();
        queue.add(new Coin(initX1, initY1, initX2, initY2));
        int[][][] visited = new int[2][N][M];

        while (!queue.isEmpty()) {
            Coin coin = queue.poll();
            int x1 = coin.x1();
            int y1 = coin.y1();
            int x2 = coin.x2();
            int y2 = coin.y2();

            // 버튼을 10번보다 더 많이 누르게 될 경우 (이미 10번을 누름)
            if (visited[0][x1][y1] >= 10) {
                return -1;
            }

            // 상하좌우 반복
            for (int j = 0; j < 4; j++) {
                int nx1 = x1 + directions[j][0];
                int ny1 = y1 + directions[j][1];
                int nx2 = x2 + directions[j][0];
                int ny2 = y2 + directions[j][1];

                // 떨어진 경우. 근데 하나만 떨어져야댐
                boolean drop1 = nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M;
                boolean drop2 = nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M;
                if ((drop1 && !drop2) || (!drop1 && drop2)) {
                    return Math.min(visited[0][x1][y1] + 1, visited[1][x2][y2] + 1);
                }

                if (drop1 && drop2) continue;

                // 벽인 경우 무시. 아니면 이동
                if (!(board[nx1][ny1] == STATE.WALL) && visited[0][nx1][ny1] == 0) {
                    visited[0][nx1][ny1] = visited[0][x1][y1] + 1;
                } else {
                    nx1 = x1;
                    ny1 = y1;
                }

                if (!(board[nx2][ny2] == STATE.WALL) && visited[0][nx2][ny2] == 0) {
                    visited[1][nx2][ny2] = visited[1][x2][y2] + 1;
                } else {
                    nx2 = x2;
                    ny2 = y2;
                }

                queue.add(new Coin(nx1, ny1, nx2, ny2));
                System.out.println("(" + nx1 + ", " + ny1 + "), (" + nx2 + ", " + ny2 + ")");
                System.out.println(visited[0][nx1][ny1] + ", " + visited[1][nx2][ny2]);
            }
        }
        return -1;
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

    static class STATE {
        static final int EMPTY = 0;
        static final int WALL = 1;
    }
}

record Coin(int x1, int y1, int x2, int y2) {}